import java.io.File;
import java.io.FilenameFilter;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JOptionPane;

public class Test 
{
	public static void main(String args[])
	{
	
		final File folder = new File("C:\\Users\\Gunagisa\\Desktop\\Test\\Logs");
		int count = 0;
		Logger log = Logger.getLogger("log");
		FileHandler fh;
		//long noOfDays = 0;

		long duration = 0;
		try
		{
			fh = new FileHandler("C:\\Users\\Gunagisa\\Desktop\\Test\\delete-logs\\logs.log");
			log.addHandler(fh);
			SimpleFormatter sf = new SimpleFormatter();
			fh.setFormatter(sf);
			log.info("This is a log of deleted files\n");
		}
		catch(Exception e)
		{
			System.out.println();
		}
		final File[] files = folder.listFiles( new FilenameFilter()
		{
			public boolean accept( final File dir, final String name ) 
			{
			       return name.matches( "log.*\\.log" );
			}
		});
			
		for ( final File file : files ) 
		{
			duration = new Date().getTime() - file.lastModified();
			if (duration > (10 * 24 * 60 * 60 * 1000) && file.delete() ) 
			{
				count++;
				//System.out.println( "File "+ file.getAbsolutePath()+" is deleted");
				log.info("File "+ file.getAbsolutePath()+" is deleted");
			}		    
//			else
//			{
//				//System.err.println( "Can't remove " + file.getAbsolutePath() );
//				log.warning("Can't remove " + file.getAbsolutePath());
//			}
		}
		//System.out.println(count +" files are deleted.");
		log.info(count +" files are deleted.");
		
		JOptionPane.showMessageDialog(null, "Executed!", "System Information", JOptionPane.INFORMATION_MESSAGE);
		//JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
