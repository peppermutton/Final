package com.example.jiaoyangchen.afinal;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    public String list = "\n" +
            "AchachaVideo available - Achacha\tAdzuki Beans\tAgar Agar\n" +
            "Agave Syrup\tAjowan Seed\tAlbacore Tuna\n" +
            "Alfalfa\tALLERGY\tAllspice\n" +
            "Almond oil\tAlmonds\tAmaranth\n" +
            "Amchur (amchoor) powder\tAnchoviesVideo available - Anchovies\tAniseed\n" +
            "Annatto seed\tApple Cider Vinegar\tApple juice\n" +
            "Apple Juice Concentrate\tApples Video available - Apples \tApples - Bonza Video available - Apples - Bonza \n" +
            "Apples - BraeburnVideo available - Apples - Braeburn\tApples - Cox's Orange PippinVideo available - Apples - Cox's Orange Pippin\tApples - Golden Delicious Video available - Apples - Golden Delicious \n" +
            "Apples - Granny Smith Video available - Apples - Granny Smith \tApples - Jazz\tApples - Jonathan Video available - Apples - Jonathan \n" +
            "Apples - Red Delicious Video available - Apples - Red Delicious \tApples - Red FujiVideo available - Apples - Red Fuji\tApples - SundownerVideo available - Apples - Sundowner\n" +
            "Apples Royal Gala\tApricotsVideo available - Apricots\tArame\n" +
            "Arborio rice\tArrowroot\tArtichoke\n" +
            "Arugula\tAsafoetida\tAsian Greens\n" +
            "Asian Noodles\tAsparagusVideo available - Asparagus\tAubergine\n" +
            "AvocadoVideo available - Avocado\tAvocado - Reed\tAvocado Oil Video available - Avocado Oil \n" +
            "Avocado Spread\tBaba ghanoush\tBaby mum\n" +
            "Bacon\tBaking Powder\tBaking Soda\n" +
            "Balmain Bug\tBalsamic Vinegar\tBamboo Shoots\n" +
            "BananaVideo available - Banana\tBarberry\tBarley\n" +
            "Barley - Pearl\tBarley - Rolled\tBarley Malt\n" +
            "Barramundi\tBasil - dried\tBasil - freshVideo available - Basil - fresh\n" +
            "Basmati rice\tBay Leaves\tBean Shoots\n" +
            "Bean Sprouts\tBeansVideo available - Beans\tBeans - Broad\n" +
            "Beans - Green\tBeans - Runner\tBeans - Snake\n" +
            "Beef - OrganicVideo available - Beef - Organic\tBeetrootVideo available - Beetroot\tBeetroot powderVideo available - Beetroot powder\n" +
            "Berries\tBeurre Bosc Pear\tBeurre Bosc Pear\n" +
            "Beurre Bosc Pears\tBlack Eyed Beans\tBlack limes\n" +
            "Black Rice\tBlack tahini\tBlackberriesVideo available - Blackberries\n" +
            "Blood oranges\tBlue Cheese\tBlue Eye Trevalla\n" +
            "Blue Swimmer CrabVideo available - Blue Swimmer Crab\tBlueberries\tBocconcini\n" +
            "Bok Choy\tBonito Flakes\tBorlotti Beans\n" +
            "Bran\tBrazil Nut\tBread\n" +
            "Bread - Rice\tBread - Rye\tBread - Sour Dough\n" +
            "Bread - Spelt\tBread - White\tBread - Wholegrain\n" +
            "Bread - Wholemeal\tBrie\tBroccoliVideo available - Broccoli\n" +
            "Broccolini\tBrown Rice\tBrown rice vinegar\n" +
            "Brussels SproutsVideo available - Brussels Sprouts\tBuckwheat\tBuckwheat Noodles (see Soba)\n" +
            "Bulghur\tBurghul (see bulghur)\tBush Tomato\n" +
            "Butter\tButter Beans\tButtermilk\n" +
            "Butternut lettuce\tButternut pumpkin\tCabbage\n" +
            "Cacao\tCake\tCalamari\n" +
            "Camellia Tea Oil\tCamembert\tCamomile\n" +
            "Candle Nut\tCannellini Beans\tCanola Oil\n" +
            "Cantaloupe (see rockmelon)\tCapers\tCapsicumVideo available - Capsicum\n" +
            "Capsicum - red\tCarambola (Starfruit)\tCaraway Seed\n" +
            "Cardamom\tCarob\tCarrotVideo available - Carrot\n" +
            "Cashews\tCassia bark\tCauliflower\n" +
            "Cavalo Nero\tCayenne\tCeleriacVideo available - Celeriac\n" +
            "Celery\tCelery Seed\tCheddar\n" +
            "CherriesVideo available - Cherries\tCherry Plum\tChervil\n" +
            "ChestnutVideo available - Chestnut\tChia seeds\tChicken - Free RangeVideo available - Chicken - Free Range\n" +
            "Chickory (Belgian endive)\tChickpea\tChicory (American term) or curly endive\n" +
            "Chilli Pepper - Fresh\tChillies - dried\tChinese Broccoli\n" +
            "Chinese Cabbage\tChinese Five Spice\tChives\n" +
            "Chocolate - DarkVideo available - Chocolate - Dark\tChocolate - Milk\tChocolate coated strawberries\n" +
            "Choy Sum\tCinnamon\tClams\n" +
            "Cloves\tCocoa powder\tCoconut\n" +
            "Coconut Cream\tCoconut Oil\tCoconut water\n" +
            "Coffee\tCorella Pear\tCoriander Leaves\n" +
            "Coriander Seed\tCorn Oil\tCorn Syrup\n" +
            "Corn Tortilla\tCornichons\tCornmeal\n" +
            "Cos lettuce\tCottage Cheese\tCottage Cheese - low fat\n" +
            "Courgette (see zucchini)\tCous Cous\tCOVER\n" +
            "Crabs\tCranberryVideo available - Cranberry\tCream\n" +
            "Cream Cheese\tCREATIVE GOURMET RASPBERRIES\tCucumber\n" +
            "Cumin\tCumquat\tCurrants\n" +
            "Curry Leaves\tCurry Powder\tCustard ApplesVideo available - Custard Apples\n" +
            "Daikon\tDandelion\tDashi\n" +
            "DatesVideo available - Dates\tDevil\tDevil\n" +
            "Dijon mustard\tDill\tDragonfruit\n" +
            "Dried Apricots\tDuck\tEdam\n" +
            "Edamame\tEggplantVideo available - Eggplant\tEggs\n" +
            "Elderberry\tEndive\tEnglish SpinachVideo available - English Spinach\n" +
            "Extra Virgin Olive Oil (see olive oil)\tFarmed Prawns\tFeijoa\n" +
            "Fennel\tFennel Seeds\tFenugreek\n" +
            "Feta\tFigs\tFile Powder\n" +
            "Fingerlime\tFioretto\tFish Sauce\n" +
            "Flathead\tFlaxseed\tFlaxseed Oil\n" +
            "Flounder\tFlour - Besan\tFlour - Buckwheat\n" +
            "Flour - Oat\tFlour - Potato\tFlour - Rice, Brown\n" +
            "Flour - Rice, White\tFlour - Soy\tFlour - Tapioca\n" +
            "Flour - Unbleached\tFlour - Wholewheat\tFOOD ALLERGY\n" +
            "Freekeh Video available - Freekeh \tFrench eschallots\tFromage Blanc\n" +
            "fruit\tfruit\tFruit salad\n" +
            "Galangal\tGaram Masala\tGarlic\n" +
            "Garlic Chives\tGem\tGinger\n" +
            "Goat's Cheese\tGoat's Milk\tGoji Berry\n" +
            "Good mood food\tGrape Seed Oil\tGrapefruit\n" +
            "GrapesVideo available - Grapes\tGrapes - red seedless\tGreen Chicken Curry\n" +
            "Green Pepper (see capsicum)\tGreen Tea\tGreen Tea noodles\n" +
            "Greenwheat Freekeh (see Freekeh)\tGruyere\tGuava\n" +
            "Gula Melaka\tHaloumi\tHam\n" +
            "Haricot Beans\tHarissa\tHazelnut\n" +
            "Hijiki\tHiramasa Kingfish\tHokkien Noodles\n" +
            "HoneyVideo available - Honey\tHoneydew melon\tHorseradish\n" +
            "Hot smoked salmon\tHummus (see recipe list)\tIceberg lettuce\n" +
            "Incaberries Video available - Incaberries \tJarrahdale pumpkin\tJasmine rice\n" +
            "Jelly\tJerusalem Artichoke\tJewfish\n" +
            "Jicama\tJohn Dory\tjuicer\n" +
            "Juniper Berries\tKaffir Lime Leaves\tKale\n" +
            "Kalettes\tKangaroo\tKecap Manis\n" +
            "Kenchur (Kencur)\tKidney Beans\tKidneys\n" +
            "Kimchi\tKiwi Fruit\tKiwiberries\n" +
            "Kohlrabi\tKokam\tKombu\n" +
            "Koshihikari rice\tKudzu\tKumera (Sweet Potato )\n" +
            "LambVideo available - Lamb\tLaugh for health\tLavender Flowers\n" +
            "Leatherjacket\tLecithin\tLeeksVideo available - Leeks\n" +
            "LemonVideo available - Lemon\tLemon Myrtle\tLemongrass\n" +
            "Lentils\tLettuce - Cos (see cos lettuce)\tLicorice\n" +
            "LimesVideo available - Limes\tLing\tLiver\n" +
            "Lobster\tLongan\tLoquats\n" +
            "Lotus Root\tLSA\tLycheesVideo available - Lychees\n" +
            "Macadamia NutVideo available - Macadamia Nut\tMacadamia oil\tMace\n" +
            "Mackerel\tMackerel - Tinned\tMahi mahi\n" +
            "Mahlab\tMalt vinegar\tMandarins\n" +
            "MangoVideo available - Mango\tMangosteens\tMaple SyrupVideo available - Maple Syrup\n" +
            "Margarine\tMarigold\tMarjoram\n" +
            "Mascarpone\tMastic\tMelon - Piel de Sapo\n" +
            "Melon (See also rockmelon, honeydew, and watermelon)\tMenopause book\tMerchant stock\n" +
            "Mesclun\tMilk (Cow's)\tMilk Cow's - Reduced and Low Fat\n" +
            "Millet\tMint\tMirin\n" +
            "Mirror Dory\tMiso\tMolasses\n" +
            "Monkfish\tMorwong\tMountain Bread\n" +
            "Mozzarella\tMuesli\tMulberries\n" +
            "Mullet\tMUM\tMung Beans\n" +
            "Mung Beans (dried)\tMushroom - FlatVideo available - Mushroom - Flat\tMushrooms - Brown Video available - Mushrooms - Brown \n" +
            "Mushrooms - Common Cultivated Video available - Mushrooms - Common Cultivated \tMushrooms - EnokiVideo available - Mushrooms - Enoki\tMushrooms - Oyster Video available - Mushrooms - Oyster \n" +
            "Mushrooms - Shiitake Video available - Mushrooms - Shiitake \tMusselsVideo available - Mussels\tMustard\n" +
            "Mustard Seed\tNashi Pear\tNasturtium\n" +
            "Nasturtium\tNectarinesVideo available - Nectarines\tNectarines - white\n" +
            "Nicole\tNigella seed\tNori\n" +
            "Nutmeg\tNutritional Yeast\tNuts\n" +
            "Oat milkVideo available - Oat milk\tOatmeal\tOats - Coarse\n" +
            "Oats - Rolled\tOca\tOcean Perch\n" +
            "Octopus\tOkra\tOlive OilVideo available - Olive Oil\n" +
            "Olives\tOmega Spread\tONE LIFE\n" +
            "Onion - Brown\tOnion - Red\tOnion - White\n" +
            "Orange Roughy\torange-blood\tOrangesVideo available - Oranges\n" +
            "Oregano\tOyster Sauce\tOystersVideo available - Oysters\n" +
            "Packham Pear\tPandanus leaves\tPandoro\n" +
            "Panetonne\tPapaw (see also yellow papaw) Video available - Papaw (see also yellow papaw) \tPapaya (see also red papaya) Video available - Papaya (see also red papaya) \n" +
            "Paprika - Hot, Sweet, Mild, Smoked\tParadise Pears\tParmesan cheese\n" +
            "Parrotfish\tParsley\tParsnip\n" +
            "Passionfruit\tPasta - Dried\tPasta - dried wholegrain\n" +
            "Pasta - Fresh\tPeachesVideo available - Peaches\tPeanuts\n" +
            "Pear Juice Concentrate\tPearsVideo available - Pears\tPeas  Video available - Peas  \n" +
            "Pecan NutVideo available - Pecan Nut\tPecorino\tPepitas\n" +
            "Pepper, Szechuan\tPepperberry, Native\tPeppercorns\n" +
            "Peppermint (see Mint)\tPeppers (see Capsicum)\tPersimmonVideo available - Persimmon\n" +
            "Pine Nut\tPineapple\tPinto Beans\n" +
            "Pistachio NutVideo available - Pistachio Nut\tPlumsVideo available - Plums\tPolenta\n" +
            "Pomegranate\tPomegrante molasses\tPoppy SeedVideo available - Poppy Seed\n" +
            "Porcini mushrooms\tPork\tPotatoes Video available - Potatoes \n" +
            "Potatoes - Desiree\tPotatoes - Kipfler\tPotatoes - Pontiac\n" +
            "Prawns\tPreserved lemon\tPrickly Pear\n" +
            "Provolone\tPrunesVideo available - Prunes\tPumpkinVideo available - Pumpkin\n" +
            "Pumpkin - Jap\tPumpkin Seed\tPurple carrot\n" +
            "Purple Rice\tQuail\tQuark\n" +
            "QuinceVideo available - Quince\tQuinoa\tRadicchio\n" +
            "Radicchio Castelfranco\tRadish\tRaisin\n" +
            "Raspberry\tRed cabbage\tRed Lentils\n" +
            "Red Lentils\tRed papaya Video available - Red papaya \tRed Pepper\n" +
            "Red Wine Vinegar\tRedfish\tRhubarb\n" +
            "Rice milkVideo available - Rice milk\tRice Noodles\tRice paper\n" +
            "Rice Syrup\tRicemilk ( see Rice milk)\tRicotta\n" +
            "Rocket\tRockmelon\tRose Water\n" +
            "Rosemary\tRye\tSafflower Oil\n" +
            "Saffron\tSage\tSake\n" +
            "Salad\tSalmonVideo available - Salmon\tSalmon - canned\n" +
            "Sardines (pilchards)\tSausages\tScallops\n" +
            "Sea Salt\tSemolina\tSesame Oil\n" +
            "Sesame seed\tSesame Seeds - white, golden, black\tShallots\n" +
            "Shark\tShoyu\tSilver Trevally\n" +
            "Silverbeet Video available - Silverbeet \tSlivered Almonds\tSmoked Trout\n" +
            "Snapper\tSnowpea sprouts\tSnowpeas\n" +
            "Soba\tSorrel\tSoupmaker\n" +
            "Soy Beans\tSoy Milk\tSoy Sauce\n" +
            "Soy Sprouts\tSoymilk ( see soy milk)\tSpanner Crab\n" +
            "Spatchcock\tSpearmint\tSpelt\n" +
            "SpinachVideo available - Spinach\tSpring Onions\tSquash\n" +
            "Squid\tStar Anise\tStar Fruit\n" +
            "Stevia\tStock- Beef\tStock- Chicken\n" +
            "Stock- Fish\tStock- Vegetable\tStrawberries\n" +
            "Strudel\tSugar\tSugarsnap peas\n" +
            "Sultanas\tSumac\tSun dried tomatoes\n" +
            "Sunflower Oil\tSunflower Seeds\tSwede\n" +
            "Sweet Chilli Sauce\tSweet Potato\tSweet Potato - white (see sweet potato)\n" +
            "SweetcornVideo available - Sweetcorn\tSwiss Chard\tSwordfish\n" +
            "Tabasco\tTable Spread (see margarine)\tTahini\n" +
            "Taleggio cheese\tTamari Video available - Tamari \tTamarillo\n" +
            "Tangelo\tTapioca\tTarragon\n" +
            "Tea\tTea Oil\tTempeh\n" +
            "Threadfin Bream\tThyme\tTofu\n" +
            "Tom Yum\tTomatoVideo available - Tomato\tTomato Truss\n" +
            "Tomatoes - Roma\tTriticale\tTrout\n" +
            "TRUPPS WHOLEFOOD KITCHEN\tTuna\tTuna - tinnedVideo available - Tuna - tinned\n" +
            "Turkey\tTurmeric\tTurnips (Swedes)\n" +
            "Umeboshi\tVanilla Beans & Extract\tVeal\n" +
            "Vegetable Oil\tVegetable spaghetti\tVerjuice\n" +
            "Vermicelli Noodles\tVinegar\tWakame\n" +
            "WalnutVideo available - Walnut\tWarehou\tWasabi\n" +
            "Water\tWatercress\tWatermelon\n" +
            "Wattleseed\tWheat\tWheatgrass juice\n" +
            "White rice\tWhite wine vinegar\tWhiting\n" +
            "Wild Rice\tWilliam Pear\tWine - Red\n" +
            "Wine- White\tWitlof\tWolfberry\n" +
            "Yeast\tYellow Papaw Video available - Yellow Papaw \tYellowtail Kingfish\n" +
            "Yoghurt\tYoghurt - Low Fat\tYoghurt - Sheeps Milk\n" +
            "Zatar\tZucchiniVideo available - Zucchini\n";

    private static final String API_KEY = "IfHzAq2ZUXmshfT8umIo3eyu1LIUp1CKPKzjsnv48t5emi4ZaY";
    private RequestQueue requestQueue;
    private static String TAG = "Final";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestQueue = Volley.newRequestQueue(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView dips = findViewById(R.id.display);
Button button = findViewById(R.id.clickbutton);
 final TextInputEditText type = findViewById(R.id.enterhere);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        process();
        /**String inputs = type.getText().toString();
        String[] breakdown = inputs.split(" ");
        String result = "";
        for (String word:breakdown) {
            if (list.contains(word)) {
                result = result + "Tasks.ProcessTex " + word;
            }
        }
        dips.setText(result);**/
        }});

    }
public void process () {
    TextInputEditText type = findViewById(R.id.enterhere);
    String input = type.getText().toString();
        new Tasks.ProcessText(this).execute(input);
    }
    }

