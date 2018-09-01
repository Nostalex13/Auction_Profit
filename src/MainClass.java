import java.io.*;
import java.util.HashMap;
import java.util.regex.*;

public class MainClass {
	public String profit = null;

	private HashMap<String, String> itemsMap = new HashMap<String, String>();
	private float procCoeficient = 1.5f;
	private float bankTax = 0.95f;
	
    private double anchorWeed;
    private double winterWeed;
    private double akundaWeed;
    private double riverbudWeed;
    private double seaWeed;
    private double sirenWeed;
    private double starWeed;
   

	public MainClass() {
		String[] items = {
				"�����-�����",
				"������� ����",
				"���� ������",
				"������ �����",
				"������� �������",
				"������ ������",
				"�������� ���",
				"������ ��������� ������",
				"������ ����������� ���������",
				"������ ���� ������",
				"������ ������������� �������",
				"������ ����� ����",
				"������ ����� ����������",
				"������ ����� ��������",
				"������ ����� ������������",
				"����� ��������� ��������",
				"����� �����������",
				"����� ������������� �������",
				"������� ���",
				"������������� �����",
				"�������������� �����"
				
		};

		for (String item : items)
			if (!Cena(item))
				return;
		
		InitializeWeed();

		profit =  "";
		
		AgilityPot();
		StaminaPot();
		IntelligencePot();
		StrengthPot();
		ManaPot();
		SoloTargetMeleePot();
		SoloTargetRangePot();
		
		profit += "\n";
		
		StaminaFlask();
		StrengthFlask();
		IntelligenceFlask();
		AgilityFlask();
		
		profit += "\n";
		
		CraftFromLeather();
		CraftFromTidespray();
	}

	private  void InitializeWeed() {
		anchorWeed = Double.parseDouble(itemsMap.get("�����-�����"));
		winterWeed = Double.parseDouble(itemsMap.get("������� ����"));
		akundaWeed = Double.parseDouble(itemsMap.get("���� ������"));
		riverbudWeed = Double.parseDouble(itemsMap.get("������ �����"));
		seaWeed = Double.parseDouble(itemsMap.get("������� �������"));
		sirenWeed = Double.parseDouble(itemsMap.get("������ ������"));
		starWeed = Double.parseDouble(itemsMap.get("�������� ���"));
	}

 //-------- POTS --------

	public void AgilityPot() {
	    double selfPrice = ParseItem("������ ����� ��������") * bankTax;
	    double reagentsPrice = (10 * sirenWeed + 8 * riverbudWeed) / procCoeficient;

	    String str = "Agility_Pot: \t\t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private void StaminaPot() {
	    double selfPrice = ParseItem("������ ����� ������������") * bankTax;
	    double reagentsPrice = (10 * seaWeed + 8 * starWeed) / procCoeficient;

	    String str = "Stamina_Pot: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private void IntelligencePot() {
	    double selfPrice = ParseItem("������ ����� ����������") * bankTax;
	    double reagentsPrice = (10 * sirenWeed + 8 * riverbudWeed) / procCoeficient;

	    String str = "Intelligence_Pot: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private void StrengthPot() {
	    double selfPrice = ParseItem("������ ����� ����") * bankTax;
	    double reagentsPrice = (10 * seaWeed + 8 * starWeed) / procCoeficient;

	    String str = "Strength_Pot: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private void ManaPot() {
	    double selfPrice = ParseItem("����� �����������") * bankTax;
	    double reagentsPrice = (10 * seaWeed + 8 * starWeed) / procCoeficient;

	    String str = "Mana_Pot: \t\t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private void SoloTargetMeleePot() {
	    double selfPrice = ParseItem("����� ��������� ��������") * bankTax;
	    double reagentsPrice = (10 * sirenWeed + 8 * riverbudWeed) / procCoeficient;

	    String str = "SoloTargetMelee_Pot: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private void SoloTargetRangePot() {
	    double selfPrice = ParseItem("����� ������������� �������") * bankTax;
	    double reagentsPrice = (10 * seaWeed + 8 * starWeed) / procCoeficient;

	    String str = "SoloTargetMelee_Pot: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

//-------- FLASKS --------

	private void AgilityFlask() {
	    double selfPrice = ParseItem("������ ������������� �������") * bankTax;
	    double reagentsPrice = (5 * anchorWeed + 10 * akundaWeed + 15 * seaWeed) / procCoeficient;

	    String str = "Agility_Flask: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private void StrengthFlask() {
	    double selfPrice = ParseItem("������ ���� ������") * bankTax;
	    double reagentsPrice = (5 * anchorWeed + 10 * akundaWeed + 15 * sirenWeed) / procCoeficient;

	    String str = "Strength_Flask: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private void IntelligenceFlask() {
	    double selfPrice =ParseItem("������ ��������� ������") * bankTax;
	    double reagentsPrice = (5 * anchorWeed + 10 * winterWeed + 15 * riverbudWeed) / procCoeficient;

	    String str = "Intelligence_Flask: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private void StaminaFlask() {
	    double selfPrice = ParseItem("������ ����������� ���������") * bankTax;
	    double reagentsPrice = (5 * anchorWeed + 10 * winterWeed + 15 * starWeed) / procCoeficient;

	    String str = "Stamina_Flask: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}
	//-------- ANOTHER -------
	private void CraftFromTidespray() {
		double selfPrice = ParseItem("������� ���");
			String str = "CraftFromTidespray: \t" + Math.round(CalculateProfit(25000, selfPrice)) + "%\n";
			profit += str;

	}
	private void CraftFromLeather() {
		double selfPrice = ParseItem("������������� �����")*8+ParseItem("�������������� �����")*10;
		String str = "CraftFromLeather: \t" + Math.round(CalculateProfit(560000, selfPrice)) + "%\n";
			profit += str;
	}


//
	private double ParseItem(String name) {
		return Double.parseDouble(itemsMap.get(name));
	}
	
	private double GetGoldAmount(double value) {
		return value / 10000;
	}

	private double CalculateProfit(double selfPrice, double reagentsPrice) {
		double profit = 0;
		if (selfPrice > reagentsPrice) {
			profit = (selfPrice / reagentsPrice) * 100 - 100;
		} else {
			profit = -((reagentsPrice / selfPrice) * 100 - 100);
		}

		return CheckMaxBound(profit);
	}

	private double CheckMaxBound(double value) {
		if (value >= 0)
			return value >= 9999 ? 9999 : value;
		else
			return value <= -9999 ? -9999 : value;
	}

	private boolean Cena(String item) {
		FinderAc finderAc = new FinderAc(InputHandler.Instance.GetName());
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(finderAc.GetPath()),"UTF-8"))) 
		{
			String str = br.readLine();
			while((!str.startsWith("AUCTIONATOR_PRICE_DATABASE = {")) & (str != null))
			{
				str = br.readLine();
			}

			str = br.readLine();

			while((str != null) & (!str.contains(item)))
			{
				str = br.readLine();
			}

			while((str != null) & (!str.contains("mr")))
			{
				str = br.readLine();
			}

			Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
			Matcher matcher = pat.matcher(str);
			
			while (matcher.find()) {
			    str = matcher.group();
			}
			
			itemsMap.put(item, str);
			
			return true;
		}
		catch(IOException ex) {
			System.out.println("error");
		}
		catch(NullPointerException ex) {
			System.out.println("Couldn`t read Auctionator.lua file");
		}
		
		return false;
	}

	/*private void ShowAllItems() {
		System.out.print(itemsMap);
	}*/
}
