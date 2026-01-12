package com.gmail.activator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.gmail.csvparserprovider.AdvancedConnectsComparator;
import com.gmail.csvparserprovider.CSVConverterProvider;
import com.gmail.csvparserprovider.ConnectsFilterProvider;
import com.gmail.csvparserprovider.FileToStringProvider;
import com.gmail.csvparserprovider.MembershipSaverProvider;
import com.gmail.csvparserprovider.TXTFilterProvider;
import com.gmail.csvparserprovider.TXTParserProvider;

public class Activator {
	private CSVConverterProvider conv;
	private TXTParserProvider parcer;
	private FileToStringProvider ftp;
	private TXTFilterProvider tfp;
	private MembershipSaverProvider saver;
	private ConnectsFilterProvider cfp;
	private AdvancedConnectsComparator acc;

	public Activator() {
		conv = new CSVConverterProvider();
		parcer = new TXTParserProvider();
		ftp = new FileToStringProvider();
		tfp = new TXTFilterProvider();
		saver = new MembershipSaverProvider();
		cfp = new ConnectsFilterProvider();
		acc = new AdvancedConnectsComparator();
	}

	public static void main(String[] args) throws IOException {
		Activator act = new Activator();
		ConnectsFilterProvider cfp = new ConnectsFilterProvider();
		File file = new File("/Users/olegivanov/Desktop/WORK/SPECIAL MEETING/CurrentMonthMembers.csv");
		File streams = new File("/Users/olegivanov/Desktop/WORK/SPECIAL MEETING/CurrentMonthStreams.csv");
		List<String> pro = act.getProMembers(file);
		List<String> advanced = act.getAdvancedMembers(file);
		
		List<String> connects = act.getCurrentMonthConnects(streams);
		List<String> advConnects = act.getAdvancedWithConnects(connects, pro);

	}

	static {
		File cr = new File("/Users/olegivanov/Desktop/zero.txt");
		try {
			cr.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String reminder = "REMINDER: \n1.Convert memberships file to csv  \n2.Put it to SPECIAL MEETING Folder \n3.Name it \"CurrentMonthMembers\" \n4.Run getCheckedMembers from current class";
		String reminder2 = "REMINDER2: \n1.Convert streams file to csv  \n2.Put it to SPECIAL MEETING Folder \n3.Name it \"CurrentMontStreams\" \n4.Run compareAdvancedMembersConnects from current class";
		System.out.println(reminder + "\n" + reminder2);

		try (PrintWriter pw = new PrintWriter(cr)) {
			pw.print(reminder);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<String> getProMembers(File file) throws IOException {

		File converted = conv.readCSV(file);
		String txt = ftp.convertFileToString(converted);
		List<List<String>> result = parcer.parceTXT(txt);
		String pro = "Профессиональная";

		List<String> professional = tfp.filterParced(result, pro);

		saver.saveMembership(professional, pro);
		return professional;
	}

	public List<String> getAdvancedMembers(File file) throws IOException {

		File converted = conv.readCSV(file);
		String txt = ftp.convertFileToString(converted);
		List<List<String>> result = parcer.parceTXT(txt);

		String adv = "Продвинутая";

		List<String> advanced = tfp.filterParced(result, adv);

		saver.saveMembership(advanced, adv);
		return advanced;
	}

	public List<String> getCurrentMonthConnects(File file) throws IOException {
		String cons = "Connects";
		File converted = conv.readCSV(file);
		String mark1 = "Connect Украина";
		String mark1_1 ="уикенд-семинара";//if qualification is the participance in WES online
		String mark1_2 ="уикенд-семинар";//if qualification is the participance in WES offline
//		String mark2 = cfp.getCurrentMonth().substring(0, cfp.getCurrentMonth().indexOf(".")+1);
		String mark3 = cfp.getCurrentMonth().substring(0, cfp.getCurrentMonth().indexOf(".")+1);//if qualification is the participance in WES
		System.out.println(mark3);
		List<String> connects = cfp.defineConnects(converted, mark1_1, "июля");
		System.out.println(connects);
		saver.saveMembership(connects, cons);
		return connects;
	}

	public List<String> getAdvancedWithConnects(List<String> connects, List<String> pro) throws IOException {
		String advConnects = "Профессиональная с Коннектом";
		List<String>result = acc.compare(pro, connects);
		saver.saveMembership(result, advConnects);
		return result;
	}

}
