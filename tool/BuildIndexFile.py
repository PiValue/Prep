# Hacky Helper script that reads metadata from all the README files in the input directory and organizes
# index.md file with categorized README files.
import os
import sys
import collections
from sets import Set

inputDirectory = "./"   # Hard coding to current directory.

class FileInfo:
    fpath = ""
    title = ""
    tags = ""
    def __init__(self, fpath, title, tags):
        self.fpath = fpath
        self.title = title
        self.tags = tags

def getAllMarkdownFiles(directory):
    files = []
    for dirpath, dirnames, filenames in os.walk(directory):
        for filename in [f for f in filenames if f.endswith(".md")]:
            files.append(os.path.join(dirpath, filename))
    return files

def getTags(metadataLines):
    tags = []
    for line in metadataLines:
        if line.startswith("tags"):
            return [tag.strip() for tag in line.split(":")[1].strip().split(",")]
    raise Exception("Tags not found in this file")

def getTitle(metadataLines):
    for line in metadataLines:
        if line.startswith("title"):
            return line.split(":")[1].strip().replace('"', '')
    raise Exception("No title found in this file")

def getFileMetadata(fpath):
    metadataLines = []
    started = False
    fp = open(fpath)
    lines = fp.readlines()
    fp.close()
    indices = [i for i, line in enumerate(lines) if line.strip() == "---"]
    if len(indices) != 2:
        raise Exception("File contain more than one metadata tags! File: " + fpath)
    metadataLines = lines[indices[0] + 1 : indices[1]]
    return (getTitle(metadataLines), getTags(metadataLines))

def generateLine(fileinfo):
    return "* [" + fileinfo.title + "]" + "(" + fileinfo.fpath + ")" + "\n"

# Generate by sorting keys and again the list under that key, so we generate a consistent output.
def generateIndexFile(tagsDictionary):
    lines = []
    for tag in sorted(tagsDictionary):
        lines.append("### " + tag + "\n")
        tagsDictionary[tag].sort(key = lambda x: x.title)
        for fileinfo in tagsDictionary[tag]:
            lines.append(generateLine(fileinfo))
        lines.append("\n")
    return lines

def generateAllFilesList(markdownFilesList):
    lines = []
    for fpath in markdownFilesList:
        (title, tags) = getFileMetadata(fpath)
        lines.append(generateLine(FileInfo(fpath = fpath, title = title, tags = tags)))
    return lines

# Hardcoded start path
markdownFiles = getAllMarkdownFiles("./src/")

allTags = Set()

mappedByTag = collections.OrderedDict()
for fpath in markdownFiles:
    (title, tags) = getFileMetadata(fpath)
    for tag in tags:
        allTags.add(tag)
        if tag not in mappedByTag:
            mappedByTag[tag] = []
        mappedByTag[tag].append(FileInfo(fpath = fpath, title = title, tags = tags))

lines = generateIndexFile(mappedByTag)
fp = open("README.md", "w")
# Write out list of all files at the top.
fp.write("## Summary\n")
fp.write("There are " + str(len(markdownFiles)) + " questions and " + str(len(allTags)) + " unique tags.\n\n")
for line in generateAllFilesList(markdownFiles):
    fp.write(line)
fp.write("\n")

fp.write("## Questions\n")
for line in lines:
    fp.write(line)
fp.close()