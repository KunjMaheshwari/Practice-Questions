import java.util.*;

class AppInfo{
    private String appid;
    private String developer;
    private int sizeinMB;
    private boolean isFree;

    public AppInfo(){};

    public AppInfo(String appid, String developer, int sizeinBM, boolean isFree){
        this.appid = appid;
        this.developer = developer;
        this.sizeinMB = sizeinBM;
        this.isFree = isFree;
    }

    public String getAppid(){
        return appid;
    }

    public void setAppid(String appid){
        this.appid = appid;
    }

    public String getDeveloper(){
        return developer;
    }

    public void setDeveloper(String developer){
        this.developer = developer;
    }

    public int getSizeinMB(){
        return sizeinMB;
    }

    public void setSizeinMB(int sizeinBM){
        this.sizeinMB = sizeinBM;
    }

    public boolean getIsFree(){
        return isFree;
    }

    public void setIsFree(boolean isFree){
        this.isFree = isFree;
    }

    public static AppInfo verifyAppDetails(String appDetails) throws InvalidAppInfoException{
        String parts[] = appDetails.split(":");
        if(parts.length!=4){
            throw new InvalidAppInfoException("Invalid App details");
        }

        String appid = parts[0].trim();
        String developer = parts[1].trim();
        String sizeStr = parts[2].trim();
        String isFree = parts[3].trim();

        if(!appid.matches("APP\\d{3}")){
            throw new InvalidAppInfoException("Invalid App Details");
        }
        if(!developer.matches("[a-zA-Z]+")){
            throw new InvalidAppInfoException("Invalid App Details");
        }
        

        int size;
        try{
            size = Integer.parseInt(sizeStr);
        }catch(NumberFormatException e){
            throw new InvalidAppInfoException("Invalid App Details");
        }

        if(size < 10 || size > 1000){
            throw new InvalidAppInfoException("Invalid App Details");
        }

        if(!isFree.equals("true") && !isFree.equals("false")){
            throw new InvalidAppInfoException("Invalid App Details");
        }

        boolean isFreeStr = Boolean.parseBoolean(isFree);

        return new AppInfo(appid, developer, size, isFreeStr);
    }
}

class InvalidAppInfoException extends Exception{
    public InvalidAppInfoException(String message){
        super(message);
    }
}

public class PlayStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the App Details");
        String input = sc.nextLine();

        try{
            AppInfo app = AppInfo.verifyAppDetails(input);
            System.out.println("App Details");
            System.out.println("App Id: "+ app.getAppid());
            System.out.println("Developer: "+ app.getDeveloper());
            System.out.println("Size in MB: "+ app.getSizeinMB());
            System.out.println(app.getIsFree() ? "Free for use" : "Not Free for use");
        }catch(InvalidAppInfoException e){
            System.out.println(e.getMessage());
        }
    }
}
