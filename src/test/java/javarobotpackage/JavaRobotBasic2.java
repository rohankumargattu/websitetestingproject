package javarobotpackage;

public class JavaRobotBasic2
{
	public static void main(String[] args) throws Exception
	{
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
