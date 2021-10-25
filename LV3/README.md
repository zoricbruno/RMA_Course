# Laboratorijska vježba 3

## Trajna pohrana podataka

Za trajnu pohranu podataka na Android platformi moguće je koristiti nekoliko različitih pristupa. Za spremanje jednostavnih podataka, postavki i slično koriste se dijeljene postavke (engl. *shared preferences*). Za veće količine strukturiranih podataka kojima je moguće upravljati koristi se Sqlite baza podataka. Treći način pohrane je korištenje običnih datoteka na uređaju za pohranu. Četvrti način jest korištenje pohrane koja se nalazi na udaljenoj lokaciji, uporabom bilo vlastitog *backend* rješenja bilo gotovih rješenja poput usluge *Firebase*. Fokus ove LV jest lokalna pohrana i to uporabom dijeljenih postavki i lokalne baze podataka.

### Dijeljene postavke 

Dijeljene    postavke  (engl. Shared  Preferences)omogućuju spremanje manjih količina podataka u obliku para ključ/vrijednost  u XML datoteku, nakon čega je timvrijednostima moguće pristupati na jednostavan način. Kao što i  ime kaže,najčešće se koriste za pohranu nekih konfiguracijskih detalja, kao npr.  preferirani  poredak elemenata liste i sl. Kako bi se rabile, najčešće se kreiraju pomoćne klase koje olakšava postupak pohrane i dohvaćanja.

* **[Obavezno]** Pročitati poglavlje 3.1. (Dijeljene postavke) u predlošku i proći kroz primjere
* **[Dodatno]** [Dodatni primjer](https://guides.codepath.com/android/Storing-and-Accessing-SharedPreferences)
* **[Dodatno]** [Jednostavne upute](https://developer.android.com/training/data-storage/shared-preferences)
* **[Dodatno]** [Dokumentacija](https://developer.android.com/reference/android/content/SharedPreferences)	

### Baza podataka

Osim dijeljenih postavki i uobičajenih datoteka, Android nudi mogućnost pohrane u bazu podataka. Riječ je o SQLite bazi, prilagođenoj za rad u okruženju s ograničenim resursima. 

* **[Obavezno]** Pročitati poglavlje 3.2. (Korištenje baze podataka) u predlošku i proći kroz primjere
* **[Obavezno]** Pogledati video [Florina Muntenescu - Room](https://www.youtube.com/watch?v=SKWh4ckvFPM)
* **[Obavezno]** Proći kroz codelab [Create a Room database](https://codelabs.developers.google.com/codelabs/kotlin-android-training-room-database/#0)
* **[Dodatno]** [Tutorial - kako koristiti room](https://guides.codepath.com/android/Room-Guide)
* **[Dodatno]** Proučiti livedata i viewmodel klase (korisno za LV4) [Room with a view](https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/#0)

### Zadaci
1. **Zadatak 1.** Kreirajte mini aplikaciju za brojanje ptica. Aplikacija se treba sastojati od jednog *TextView-a*, četiri gumba (svaki od gumba predstavlja boju ptice) te gumba za reset brojača i boje. Klikom na neki od gumba za boju ptice inkrementira ukupan brojač i mijenja pozadinu kontrole koja prikazuje brojač na boju zadnje viđene ptice. Stanje aplikacije mora preživjeti gašenje i ponovno pokretanje aplikacije, vrijednosti pohraniti u dijeljene postavke.
2. **Zadatak 2.** Zadatak iz LV2 koji je služio za pohranu inspirirajućih osoba proširite tako da umjesto liste u memoriji koristite Room bazu podataka i sve podatke pohranjujete u bazu.





