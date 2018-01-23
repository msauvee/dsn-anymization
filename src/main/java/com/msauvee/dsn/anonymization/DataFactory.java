package com.msauvee.dsn.anonymization;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

class DataFactory {

    private final String[] FIRST_NAMES = {"Jean","Marie","Philippe","Nathalie","Michel","Isabelle","Alain","Sylvie","Patrick","Catherine","Nicolas","Laurie","Christophe","Christine","Pierre","Françoise","Christian","Valerie","Éric","Sandrine","Frédéric","Stephanie","Laurent","Veronique","Stéphane","Sophie","David","Celine","Pascal","Chantal","Daniel","Patricia","Sébastien","Anne","Julien","Brigitte","Thierry","Julie","Olivier","Monique","Bernard","Aurelie","Thomas","Nicole","Alexandre","Laurence","Gérard","Annie","Didier","Émilie","Dominique","Dominique","Vincent","Virginie","François","Corinne","Bruno","Elodie","Guillaume","Christelle","Jérôme","Camille","Jacques","Caroline","Marc","Lea","Maxime","Sarah","Romain","Florence","Claude","Laetitia","Antoine","Audrey","Franck","Helene","Jean-Pierre","Laura","Anthony","Manon","Kévin","Michele","Gilles","Cecile","Cédric","Christiane","Serge","Beatrice","André","Claire","Mathieu","Nadine","Benjamin","Delphine","Patrice","Pauline","Fabrice","Karine","Joël","Melanie","Jérémy","Marion","Clément","Chloe","Arnaud","Jacqueline","Denis","Elisabeth","Paul","Evelyne","Lucas","Marine","Hervé","Claudine","Jean-Claude","Anais","Sylvain","Lucie","Yves","Danielle","Ludovic","Carole","Guy","Fabienne","Florian","Mathilde","Damien","Sandra","Alexis","Pascale","Mickaël","Annick","Quentin","Charlotte","Emmanuel","Emma","Louis","Severine","Benoît","Sabrina","Jean-Luc","Amandine","Fabien","Myriam","Francis","Jocelyne","Hugo","Alexandra","Jonathan","Angelique","Loïc","Josiane","Xavier","Joelle","Théo","Agnes","Adrien","Mireille","Raphaël","Vanessa","Jean-Francois","Justine","Grégory","Sonia","Robert","Bernadette","Michaël","Emmanuelle","Valentin","Oceane","Cyril","Amelie","Jean-Marc","Clara","René","Maryse","Lionel","Anne-marie","Yannick","Fanny","Enzo","Magali","Yannis","Marie-christine","Jean-Michel","Morgane","Baptiste","Ines","Matthieu","Nadia","Rémi","Muriel","Georges","Jessica","Aurélien","Laure","Nathan","Genevieve","Jean-Paul","Estelle"};
    private final String[] LAST_NAMES = { "Martin","Legrand","Bernard","Garnier","Dubois","Faure","Thomas","Rousseau","Robert","Blanc","Richard","Guerin","Petit","Muller","Durand","Henry","Leroy","Roussel","Moreau","Nicolas","Simon","Perrin","Laurent","Morin","Lefebvre","Mathieu","Michel","Clement","Garcia","Gauthier","David","Dumont","Bertrand","Lopez","Roux","Fontaine","Vincent","Chevalier","Fournier","Robin","Morel","Masson","Girard","Sanchez","Andre","Gerard","Lefevre","Nguyen","Mercier","Boyer","Dupont","Denis","Lambert","Lemaire","Bonnet","Duval","Francois","Joly","Martinez","Gautier","Roger","Bourgeois","Roche","Renaud","Roy","Lemoine","Noel","Picard","Meyer","Gaillard","Lucas","Philippe","Meunier","Leclercq","Jean","Lacroix","Perez","Fabre","Marchand","Dupuis","Dufour","Olivier","Blanchard","Rodriguez","Marie","Da silva","Barbier","Hubert","Brun","Louis","Dumas","Charles","Brunet","Guillot","Schmitt","Riviere","Leroux","Le gall","Colin","Guillaume","Fernandez","Adam","Pierre","Rey","Renard","Moulin","Arnaud","Gonzalez","Rolland","Berger","Caron","Lecomte","Aubert","Menard","Giraud","Fleury","Leclerc","Deschamps","Vidal","Carpentier","Julien","Le goff","Benoit","Boucher","Paris","Bailly","Maillard","Boulanger","Marchal","Collin","Aubry","Herve","Vasseur","Evrard","Le roux","Poulain","Renault","Etienne","Jacquet","Lebrun","Collet","Daniel","Prevost","Pereira","Poirier","Pasquier","Charpentier","Cordier","Royer","Humbert","Huet","Gillet","Baron","Bouvier","Dupuy","Leveque","Pons","Albert","Paul","Ferreira","Laine","Jacob","Carre","Germain","Breton","Klein","Remy","Millet","Schneider","Weber","Perrot","Gomez","Guyot","Marechal","Barre","Gay","Marty","Chevallier","Cousin","Mallet"};
    private final String[] APE_CODES = { "0111Z","0112Z","0113Z","0114Z","0115Z","0116Z","0119Z","0121Z","0122Z","0123Z","0124Z","0125Z","0126Z","0127Z","0128Z","0129Z","0130Z","0141Z","0142Z","0143Z","0144Z","0145Z","0146Z","0147Z","0149Z","0150Z","0161Z","0162Z","0163Z","0164Z","0170Z","0210Z","0220Z","0230Z","0240Z","0311Z","0312Z","0321Z","0322Z","0510Z","0520Z","0610Z","0620Z","0710Z","0721Z","0729Z","0811Z","0812Z","0891Z","0892Z","0893Z","0899Z","0910Z","0990Z","1011Z","1012Z","1013A","1013B","1020Z","1031Z","1032Z","1039A","1039B","1041A","1041B","1042Z","1051A","1051B","1051C","1051D","1052Z","1061A","1061B","1062Z","1071A","1071B","1071C","1071D","1072Z","1073Z","1081Z","1082Z","1083Z","1084Z","1085Z","1086Z","1089Z","1091Z","1092Z","1101Z","1102A","1102B","1103Z","1104Z","1105Z","1106Z","1107A","1107B","1200Z","1310Z","1320Z","1330Z","1391Z","1392Z","1393Z","1394Z","1395Z","1396Z","1399Z","1411Z","1412Z","1413Z","1414Z","1419Z","1420Z","1431Z","1439Z","1511Z","1512Z","1520Z","1610A","1610B","1621Z","1622Z","1623Z","1624Z","1629Z","1711Z","1712Z","1721A","1721B","1721C","1722Z","1723Z","1724Z","1729Z","1811Z","1812Z","1813Z","1814Z","1820Z","1910Z","1920Z","2011Z","2012Z","2013A","2013B","2014Z","2015Z","2016Z","2017Z","2020Z","2030Z","2041Z","2042Z","2051Z","2052Z","2053Z","2059Z","2060Z","2110Z","2120Z","2211Z","2219Z","2221Z","2222Z","2223Z","2229A","2229B","2311Z","2312Z","2313Z","2314Z","2319Z","2320Z","2331Z","2332Z","2341Z","2342Z","2343Z","2344Z","2349Z","2351Z","2352Z","2361Z","2362Z","2363Z","2364Z","2365Z","2369Z","2370Z","2391Z","2399Z","2410Z","2420Z","2431Z","2432Z","2433Z","2434Z","2441Z","2442Z","2443Z","2444Z","2445Z","2446Z","2451Z","2452Z","2453Z","2454Z","2511Z","2512Z","2521Z","2529Z","2530Z","2540Z","2550A","2550B","2561Z","2562A","2562B","2571Z","2572Z","2573A","2573B","2591Z","2592Z","2593Z","2594Z","2599A","2599B","2611Z","2612Z","2620Z","2630Z","2640Z","2651A","2651B","2652Z","2660Z","2670Z","2680Z","2711Z","2712Z","2720Z","2731Z","2732Z","2733Z","2740Z","2751Z","2752Z","2790Z","2811Z","2812Z","2813Z","2814Z","2815Z","2821Z","2822Z","2823Z","2824Z","2825Z","2829A","2829B","2830Z","2841Z","2849Z","2891Z","2892Z","2893Z","2894Z","2895Z","2896Z","2899A","2899B","2910Z","2920Z","2931Z","2932Z","3011Z","3012Z","3020Z","3030Z","3040Z","3091Z","3092Z","3099Z","3101Z","3102Z","3103Z","3109A","3109B","3211Z","3212Z","3213Z","3220Z","3230Z","3240Z","3250A","3250B","3291Z","3299Z","3311Z","3312Z","3313Z","3314Z","3315Z","3316Z","3317Z","3319Z","3320A","3320B","3320C","3320D","3511Z","3512Z","3513Z","3514Z","3521Z","3522Z","3523Z","3530Z","3600Z","3700Z","3811Z","3812Z","3821Z","3822Z","3831Z","3832Z","3900Z","4110A","4110B","4110C","4110D","4120A","4120B","4211Z","4212Z","4213A","4213B","4221Z","4222Z","4291Z","4299Z","4311Z","4312A","4312B","4313Z","4321A","4321B","4322A","4322B","4329A","4329B","4331Z","4332A","4332B","4332C","4333Z","4334Z","4339Z","4391A","4391B","4399A","4399B","4399C","4399D","4399E","4511Z","4519Z","4520A","4520B","4531Z","4532Z","4540Z","4611Z","4612A","4612B","4613Z","4614Z","4615Z","4616Z","4617A","4617B","4618Z","4619A","4619B","4621Z","4622Z","4623Z","4624Z","4631Z","4632A","4632B","4632C","4633Z","4634Z","4635Z","4636Z","4637Z","4638A","4638B","4639A","4639B","4641Z","4642Z","4643Z","4644Z","4645Z","4646Z","4647Z","4648Z","4649Z","4651Z","4652Z","4661Z","4662Z","4663Z","4664Z","4665Z","4666Z","4669A","4669B","4669C","4671Z","4672Z","4673A","4673B","4674A","4674B","4675Z","4676Z","4677Z","4690Z","4711A","4711B","4711C","4711D","4711E","4711F","4719A","4719B","4721Z","4722Z","4723Z","4724Z","4725Z","4726Z","4729Z","4730Z","4741Z","4742Z","4743Z","4751Z","4752A","4752B","4753Z","4754Z","4759A","4759B","4761Z","4762Z","4763Z","4764Z","4765Z","4771Z","4772A","4772B","4773Z","4774Z","4775Z","4776Z","4777Z","4778A","4778B","4778C","4779Z","4781Z","4782Z","4789Z","4791A","4791B","4799A","4799B","4910Z","4920Z","4931Z","4932Z","4939A","4939B","4939C","4941A","4941B","4941C","4942Z","4950Z","5010Z","5020Z","5030Z","5040Z","5110Z","5121Z","5122Z","5210A","5210B","5221Z","5222Z","5223Z","5224A","5224B","5229A","5229B","5310Z","5320Z","5510Z","5520Z","5530Z","5590Z","5610A","5610B","5610C","5621Z","5629A","5629B","5630Z","5811Z","5812Z","5813Z","5814Z","5819Z","5821Z","5829A","5829B","5829C","5911A","5911B","5911C","5912Z","5913A","5913B","5914Z","5920Z","6010Z","6020A","6020B","6110Z","6120Z","6130Z","6190Z","6201Z","6202A","6202B","6203Z","6209Z","6311Z","6312Z","6391Z","6399Z","6411Z","6419Z","6420Z","6430Z","6491Z","6492Z","6499Z","6511Z","6512Z","6520Z","6530Z","6611Z","6612Z","6619A","6619B","6621Z","6622Z","6629Z","6630Z","6810Z","6820A","6820B","6831Z","6832A","6832B","6910Z","6920Z","7010Z","7021Z","7022Z","7111Z","7112A","7112B","7120A","7120B","7211Z","7219Z","7220Z","7311Z","7312Z","7320Z","7410Z","7420Z","7430Z","7490A","7490B","7500Z","7711A","7711B","7712Z","7721Z","7722Z","7729Z","7731Z","7732Z","7733Z","7734Z","7735Z","7739Z","7740Z","7810Z","7820Z","7830Z","7911Z","7912Z","7990Z","8010Z","8020Z","8030Z","8110Z","8121Z","8122Z","8129A","8129B","8130Z","8211Z","8219Z","8220Z","8230Z","8291Z","8292Z","8299Z","8411Z","8412Z","8413Z","8421Z","8422Z","8423Z","8424Z","8425Z","8430A","8430B","8430C","8510Z","8520Z","8531Z","8532Z","8541Z","8542Z","8551Z","8552Z","8553Z","8559A","8559B","8560Z","8610Z","8621Z","8622A","8622B","8622C","8623Z","8690A","8690B","8690C","8690D","8690E","8690F","8710A","8710B","8710C","8720A","8720B","8730A","8730B","8790A","8790B","8810A","8810B","8810C","8891A","8891B","8899A","8899B","9001Z","9002Z","9003A","9003B","9004Z","9101Z","9102Z","9103Z","9104Z","9200Z","9311Z","9312Z","9313Z","9319Z","9321Z","9329Z","9411Z","9412Z","9420Z","9491Z","9492Z","9499Z","9511Z","9512Z","9521Z","9522Z","9523Z","9524Z","9525Z","9529Z","9601A","9601B","9602A","9602B","9603Z","9604Z","9609Z","9700Z","9810Z","9820Z","9900Z" };
    private final String[] CITIES = {"Paris", "Lyon", "Bordeau", "Marseille", "Nantes"};

    private Company company = null;
    private Subsidiary subsidiary = null;
    private People people = null;
    private final Random random = new Random();

    public People getPeople() {       
        return people;
    }
    
    public Company getCompany() {
        return company;
    }
    
    public Subsidiary getSubsidiary() {
        return subsidiary;
    }
    
    public void nextPeople() {
        people = new People(generateFirstName(), generateLastName(), 
                generateAddress(), "01" + RandomStringUtils.randomNumeric(8),
                generateCity());
    }

    public void nextCompany() {
        String siren = "508412871";
        String nic = addLuhnToNIC(siren, "0001");
        company = new Company(generateAddress(), siren, nic , generateAPE());
        nextSubsidiary();
    }

    public void nextSubsidiary() {
        // ensure different NIC
        int previousNIC = Integer.parseInt(subsidiary == null ? company.nic.substring(0, 4) : subsidiary.nic.substring(0, 4));
        String nic = String.format("%04d", previousNIC+1);
        nic = addLuhnToNIC(company.siren, nic);
        subsidiary = new Subsidiary(generateAddress(), nic, generateAPE());
        nextPeople();
    }
        
    private String generateFirstName() {
        return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
    }
    
    private String generateLastName() {
        return LAST_NAMES[random.nextInt(LAST_NAMES.length)];
    }
    
    private String generateAPE() {
        return APE_CODES[random.nextInt(APE_CODES.length)];
    }

    private Address generateAddress() {
        return new Address(generateNumberText(100) + " rue " + generateFirstName() + " " + generateLastName());
    }
    
    public String generateNumberText(int max) {
        return Integer.toString(random.nextInt(max));
    }

    public String generateCity() {
        return CITIES[random.nextInt(CITIES.length)];
    }


    private String addLuhnToNIC(String siren, String nic) {
        return nic + generateDigit(siren  + nic);
    }
    
    private static String generateDigit(String s) {
        int digit = 10 - doLuhn(s, true) % 10;
        return "" + (digit  % 10);
    }

    private static int doLuhn(String s, boolean evenPosition) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(s.substring(i, i + 1));
            if (evenPosition) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            evenPosition = !evenPosition;
        }

        return sum;
    }
}