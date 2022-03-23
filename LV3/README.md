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
* **[Dodatno]** Upute za Room (https://johncodeos.com/how-to-use-room-in-android-using-kotlin/)

### Zadaci
1. **Zadatak 1.** Kreirajte mini aplikaciju za brojanje ptica. Definirajte klasu koja predstavlja model sa stanjem za boju, datumom i vremenom kad je ptica uočena i imenom lokacije na kojoj je uočena. Aplikacija treba imati dva fragmenta (ako želite, možete rješenje ostvariti kao 1 Activity i 1 dijalog). Prvi prikazuje listu ptica i ima gumb za dodavanje ptice, a drugi sadrži kontrole za unos viđene ptice. Prilikom dodavanja ptice, informacije se pohranjuju u bazu podataka i zatim prikazuju u listi. Stanje aplikacije mora preživjeti gašenje i ponovno pokretanje aplikacije, vrijednosti pohraniti u Room bazu podataka.





