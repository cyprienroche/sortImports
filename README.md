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
    def partition = file.readLines().split { it.startsWith("import") }
    def sortedImports = partition[0].sort() + partition[1]
    file.write(sortedImports.join("\n"))
}


```

Change the path to suit your needs. 

You can specify either relative or absolute paths to the files.
You can also specify a folder. All files in that folder as well as sub-folders will have imports sorted.

I recommend only using this for files that need imports to be sorted at one given time.
For large projects this task may add quite a large overhead. 
