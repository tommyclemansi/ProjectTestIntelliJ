package test.tom.be.fundamentals;

public abstract class AbstractFile implements Savable {

    public String getMyFilename() {
        return myFilename;
    }

    public AbstractFile(String myFilename) {
        this.myFilename = myFilename;
    }

    public AbstractFile(){
        this("defaultname");
    }


    public void setMyFilename(String myFilename) {
        this.myFilename = myFilename;
    }

    private String myFilename;

    @Override
    public void doSave()
    {
        TomsLogger.doLog("file "+ this.getMyFilename() + "saved by AbstractFile" );
    }
}