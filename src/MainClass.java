import java.io.*;
import java.util.HashMap;
import java.util.regex.*;

public class MainClass {
	public String profit;
	String name;

	private  HashMap<String, String> itemsMap = new HashMap<String, String>();
	private  float procCoeficient = 1.5f;
	private  float bankTax = 0.95f;
	
    private  double anchorWeed;
    private  double winterWeed;
    private  double akundaWeed;
    private  double riverbudWeed;
    private  double seaWeed;
    private  double sirenWeed;
    private  double starWeed;
   

	public MainClass(String _name) {
		name = _name;
		System.out.println();
		String[] items = {
				"Якорь-трава",
				"Поцелуй зимы",
				"Укус Акунды",
				"Речной горох",
				"Морской стебель",
				"Пыльца сирены",
				"Звездный мох",
				"Настой бездонных глубин",
				"Настой бескрайнего горизонта",
				"Настой силы прибоя",
				"Настой стремительных течений",
				"Боевое зелье силы",
				"Боевое зелье интеллекта",
				"Боевое зелье ловкости",
				"Боевое зелье выносливости",
				"Зелье кровавого всплеска",
				"Зелье восполнения",
				"Зелье смертоносного прилива",
				"Морской лен",
				"Окровавленная кость",
				"Поблескивающая чешуя"
				
		};

		for (int i = 0; i < items.length; i++) {
			Cena(items[i]);
		}

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
		anchorWeed = Double.parseDouble(itemsMap.get("Якорь-трава"));
		winterWeed = Double.parseDouble(itemsMap.get("Поцелуй зимы"));
		akundaWeed = Double.parseDouble(itemsMap.get("Укус Акунды"));
		riverbudWeed = Double.parseDouble(itemsMap.get("Речной горох"));
		seaWeed = Double.parseDouble(itemsMap.get("Морской стебель"));
		sirenWeed = Double.parseDouble(itemsMap.get("Пыльца сирены"));
		starWeed = Double.parseDouble(itemsMap.get("Звездный мох"));
	}

 //-------- POTS --------

	public void AgilityPot() {
	    double selfPrice = ParseItem("Боевое зелье ловкости") * bankTax;
	    double reagentsPrice = (10 * sirenWeed + 8 * riverbudWeed) / procCoeficient;

	    String str = "Agility_Pot: \t\t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private  void StaminaPot() {
	    double selfPrice = ParseItem("Боевое зелье выносливости") * bankTax;
	    double reagentsPrice = (10 * seaWeed + 8 * starWeed) / procCoeficient;

	    String str = "Stamina_Pot: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private  void IntelligencePot() {
	    double selfPrice = ParseItem("Боевое зелье интеллекта") * bankTax;
	    double reagentsPrice = (10 * sirenWeed + 8 * riverbudWeed) / procCoeficient;

	    String str = "Intelligence_Pot: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private  void StrengthPot() {
	    double selfPrice = ParseItem("Боевое зелье силы") * bankTax;
	    double reagentsPrice = (10 * seaWeed + 8 * starWeed) / procCoeficient;

	    String str = "Strength_Pot: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private  void ManaPot() {
	    double selfPrice = ParseItem("Зелье восполнения") * bankTax;
	    double reagentsPrice = (10 * seaWeed + 8 * starWeed) / procCoeficient;

	    String str = "Mana_Pot: \t\t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private  void SoloTargetMeleePot() {
	    double selfPrice = ParseItem("Зелье кровавого всплеска") * bankTax;
	    double reagentsPrice = (10 * sirenWeed + 8 * riverbudWeed) / procCoeficient;

	    String str = "SoloTargetMelee_Pot: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private  void SoloTargetRangePot() {
	    double selfPrice = ParseItem("Зелье смертоносного прилива") * bankTax;
	    double reagentsPrice = (10 * seaWeed + 8 * starWeed) / procCoeficient;

	    String str = "SoloTargetMelee_Pot: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

//-------- FLASKS --------

	private  void AgilityFlask() {
	    double selfPrice = ParseItem("Настой стремительных течений") * bankTax;
	    double reagentsPrice = (5 * anchorWeed + 10 * akundaWeed + 15 * seaWeed) / procCoeficient;

	    String str = "Agility_Flask: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private  void StrengthFlask() {
	    double selfPrice = ParseItem("Настой силы прибоя") * bankTax;
	    double reagentsPrice = (5 * anchorWeed + 10 * akundaWeed + 15 * sirenWeed) / procCoeficient;

	    String str = "Strength_Flask: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private  void IntelligenceFlask() {
	    double selfPrice =ParseItem("Настой бездонных глубин") * bankTax;
	    double reagentsPrice = (5 * anchorWeed + 10 * winterWeed + 15 * riverbudWeed) / procCoeficient;

	    String str = "Intelligence_Flask: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}

	private  void StaminaFlask() {
	    double selfPrice = ParseItem("Настой бескрайнего горизонта") * bankTax;
	    double reagentsPrice = (5 * anchorWeed + 10 * winterWeed + 15 * starWeed) / procCoeficient;

	    String str = "Stamina_Flask: \t" + Math.round(CalculateProfit(selfPrice, reagentsPrice)) + "%(" + Math.rint(100.0*GetGoldAmount(selfPrice))/100.0 + "g)\n";
	    profit += str;
	}
	//-------- ANOTHER -------
	private  void CraftFromTidespray() {
		double selfPrice = ParseItem("Морской лен");
			String str = "CraftFromTidespray: \t" + Math.round(CalculateProfit(25000, selfPrice)) + "%\n";
			profit += str;

	}
	private  void CraftFromLeather() {
		double selfPrice = ParseItem("Окровавленная кость")*8+ParseItem("Поблескивающая чешуя")*10;
		String str = "CraftFromLeather: \t" + Math.round(CalculateProfit(560000, selfPrice)) + "%\n";
			profit += str;
	}


//
	private  double ParseItem(String name) {
		return Double.parseDouble(itemsMap.get(name));
	}
	
	private  double GetGoldAmount(double value) {
		return value / 10000;
	}

	private  double CalculateProfit(double selfPrice, double reagentsPrice) {
		double profit = 0;
		if (selfPrice > reagentsPrice) {
			profit = (selfPrice / reagentsPrice) * 100 - 100;
		} else {
			profit = -((reagentsPrice / selfPrice) * 100 - 100);
		}

		return CheckMaxBound(profit);
	}

	private  double CheckMaxBound(double value) {
		if (value >= 0)
			return value >= 9999 ? 9999 : value;
		else
			return value <= -9999 ? -9999 : value;
	}

	private  void Cena(String item) {
		FinderAc finderAc = new FinderAc(name);
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
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
			System.out.println("error");
		}
	}

	/*private  void ShowAllItems() {
		System.out.print(itemsMap);
	}*/
}
