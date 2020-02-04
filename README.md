# Sort imports
sorts the imports automatically

Main.kt contains code for Kotlin. 
But I needed the task to with Grovvy since it is what my team and I agreed to use regarding gradle.

Simply add the following to your build.gradle:

```
def path = './src/main/resources/filesToSortImports.txt'

task sortImports {
    doLast {
        file(path).eachLine {
            def file = file(it)
            sortImportsFile(file)
        }
    }
}

private static void sortImportsFile(File file) {
    if (file.isFile()) {
        sortImportsIsFile(file)
    } else {
        file.listFiles().each { sortImportsFile(it) }
    }
}

private static void sortImportsIsFile(File file) {
    def partitionImp = file.readLines().split { it.startsWith("import ") }
    def partitionPack = partitionImp[1].split { it.startsWith("package ") }
    while (partitionPack[1][0] =~ /(^\s*$)/) {
        partitionPack[1] = partitionPack[1].tail()
    }
    def sortedImports = partitionPack[0].sort() + [""] + partitionImp[0].sort() + [""] + partitionPack[1]
    file.write(sortedImports.join("\n") + '\n')
}

```

Change the path to suit your needs. 

You can specify either relative or absolute paths to the files.
You can also specify a folder. All files in that folder as well as sub-folders will have imports sorted.

I recommend only using this for files that need imports to be sorted at one given time.
For large projects this task may add quite a large overhead. 
