package Solution3

interface FileSystemNode {
    abstract fun getParentElement(): String

    abstract fun getNameElement(): String

    abstract fun getPath(): String
}

abstract class AbstractFileSystemNode : FileSystemNode {
    override fun getParentElement(): String {
        return this::class.java.simpleName as String
    }

     abstract override fun getNameElement(): String

    override fun getPath(): String {
        return "${getParentElement()}/${getNameElement()}"
    }
}

open class Folder(private val folderName: String) : AbstractFileSystemNode() {
    private val folderList = mutableListOf<Folder>()

    private val getFolderName: String get() = folderName

    constructor(folderName: String, vararg folders: Folder) : this(folderName) {
        folderList.addAll(folders)
    }

    fun getChildElements(): List<Folder>{
        return folderList
    }

    override fun getNameElement(): String {
        return getFolderName
    }

    override fun toString(): String {
        return folderName
    }

}

class File(folder: Folder, private val fileName: String) : AbstractFileSystemNode() {

    private val getFileName: String get() = fileName
    private val folderName: String = folder.getNameElement()

    override fun getNameElement(): String {
        return "$folderName/$getFileName"
    }

    override fun toString(): String {
        return "File: $fileName is in $folderName"
    }

    fun getFileExtension(): String {
        val extension = fileName.lastIndexOf(".")
        return fileName.substring(extension + 1)
    }
}

fun main(){
    val fs = Folder("sub")
    val fs2 = Folder("sub1")
    val fs3 = Folder("sub2")
    val folder = Folder("root", fs, fs2, fs3)

    println(folder.getChildElements())

    val fs4 = Folder("sub4")
    val fs5 = Folder("sub5")
    val fs6 = Folder("sub6")

    val folder1 = Folder("root1", fs4, fs5, fs6)

    val rootFolder = Folder("rootRoot", folder, folder1)

    println(rootFolder.getChildElements())
    println(folder.getPath())

    println(folder1.getChildElements())

    println(fs4.getPath())

    val someFile = File(fs4, "kek.txt")

    println(someFile.getPath())

    println(someFile.getFileExtension())
}