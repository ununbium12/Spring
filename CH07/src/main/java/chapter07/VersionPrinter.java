package chapter07;

public class VersionPrinter {

    private int majorVersion;

    private int minorVersion;

    public void print() {
        System.out.printf("프로그램 버전 : %d.%d\n", majorVersion, minorVersion);
    }

    public void setMajorVersion(int major) {
        this.majorVersion = major;
    }

    public void setMinorVersion(int minor) {
        this.minorVersion = minor;
    }
}
