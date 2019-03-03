import java.io.File

fun handleDirectory(file: File)
{
    file.walk().forEach {
        directoryFile ->
        val extension = directoryFile.extension
        if((extension == "java" || extension == "kt") && directoryFile.isFile)
        {
            if(directoryFile.renameTo(File(directoryFile.absolutePath + ".2019")))
                println(directoryFile.absolutePath)
        }

    }
}

fun main(args: Array<String>)
{
    if(args.size != 1)
    {
        println("Specify exactly one directory")
        return
    }
    val directory = File(args[0])
    if(!directory.isDirectory)
    {
        println("Pass correct directory path")
        return
    }
    handleDirectory(directory)
}