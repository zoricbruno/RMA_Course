# Laboratorijska vježba 2

## Osnove razvoja Android aplikacija

Za početak razvoja potrebno je pripremiti alate koji su potrebni (razvojno okruženje, emulator ili fizički uređaj) i prisjetiti se kako izgleda osnovni projekt. Potrebno je istražiti kako se koriste resursi, kako se slažu sučelja i kako se dodaje interakcija na elemente korisničkog sučelja. Kako biste to i napravili prođite kroz sljedeće točke, sve **[Obavezno]**. 

* Pročitati poglavlje 1 (LV1) u priručniku za LV i isprobati primjere.
* Instalacija android studija i podešavanje ostatka opreme
	* [Dokumentacija](https://developer.android.com/studio/install)	
* Upravljanje dependencyima (vanjskim bibliotekama)
	* [Pročitati - prvi i drugi pristup pogotovo](https://proandroiddev.com/how-to-manage-dependencies-in-multi-module-project-84620afbb415)
* Constraint layout
	* Pročitati uvod dostupan na [Constraint layout](			https://medium.com/exploring-android/exploring-the-new-android-constraintlayout-eed37fe8d8f1)
	* Proći kroz Codelab dostupan na [Constraint layout codelab](https://codelabs.developers.google.com/codelabs/constraint-layout/index.html#0)

## Više zaslona istovremeno

Aplikacija će u pravilu imati više od jednog zaslona za prikaz sadržaja (moguće je imati i 0 :)). Kako bi se ovo podržalo,  u aplikaciju se dodaju novi *Activity* objekti ili novi *Fragment* objekti. Svaki od njih predstavlja novi zaslon ili dio zaslona. Kako biste isprobali ovo, prođite kroz sljedeće točke

* **[Obavezno]** Pročitati poglavlje 2 (LV2) u priručniku za LV i isprobati primjere.
* **[Obavezno]** Pročitati i probati pokretanje drugog *Activity*a [Developer android - basics](https://developer.android.com/training/basics/firstapp/starting-activity)
* **[Dodatno]** Primjeri s intentima [Android intents tutorial with kotlin](https://www.raywenderlich.com/4700198-android-intents-tutorial-with-kotlin)


### Puno sadržaja na jednom zaslonu

Jedan od najčešćih obrazaca korisničkog sučelja na Android platformi jest postojanje liste sadržaja po kojoj se može prolaziti skrolanjem. Da bi se postiglo takvo ponašanje, koristi se kontrola koja se naziva *RecyclerView*. S obzirom da on omogućuje prikaz objekata *View* klase, a ono što mi u danom trenutku imamo su objekti klase koja predstavlja model podataka u domeni problema koji rješavamo, koristi se obrazac *Adapter*. Kreira se klasa koja predstavlja adapter, ona u sebi čuva kolekciju podatka koju je potrebno prikazati te na zahtjev *RecyclerView* kontrole pretvara objekte konkretnih klasa u *View* objekte. Da bi se to postiglo, potrebno je definirati izgled svakog od njih korištenjem označnog jezika *XML*. 

* **[Obavezno]** Pročitati poglavlje 2 (LV2) u priručniku za vježbe i isprobati primjere
* **[Obavezno]** Proći primjer [RecyclerView fundamentals](https://codelabs.developers.google.com/codelabs/kotlin-android-training-recyclerview-fundamentals/#0)
* **[Dodatno]** [Uvod u Activity i RecyclerView]( https://www.raywenderlich.com/2705552-introduction-to-android-activities-with-kotlin)
* **[Dodatno]** [Detaljno o recyclerview kontroli](https://guides.codepath.com/android/using-the-recyclerview)

## Fragmenti

Fragmenti su klase namijenjene izgradnji fleksibilnih i ponovno iskoristivih dijelova *Activity*a. Obično fragment sadrži dio korisničkog sučelja *Activity*a, a sam *Activity* služi samo kao okvir za držanje fragmenata. Fragmenti imaju složeniji životni ciklus nego *Activity* jer imaju mogućnost reagiranja na događaje poput kreiranja *View* objekta koji prikazuju i slično kroz svoje *callback* metode. Kako biste se prisjetili/upoznali s fragmentima, možete napraviti sljedeće:

* **[Obavezno]** Proći kroz potpoglavlje *Fragmenti* u priručniku za LV i isprobati primjere
* **[Obavezno]** [Dokumentacija - Fragmenti](https://developer.android.com/guide/components/fragments)
* **[Obavezno]** [Codelab - kreiranje fragmenta](https://google.dev/codelabs/kotlin-android-training-create-and-add-fragment#0)
* **[Dodatno]** [Codepath fragments basics](https://github.com/codepath/android_guides/wiki/Creating-and-Using-Fragments)
* **[Dodatno]** [Codepath Viewpager](https://guides.codepath.com/android/google-play-style-tabs-using-tablayout)



## Zadaci

1. **Zadatak 1.** Kreirajte aplikaciju koja omogućuje prikaz informacija o inspirirajućim osobama iz svijeta računarstva. Svaka osoba predstavljena je objektom klase *InspiringPerson*. Aplikacija mora imati dva ekrana, jedan koji omogućuje unos nove osobe i drugi koji omogućuje prikaz svih osoba unutar skrolajuće liste. Koristiti *RecyclerView* kontrolu za prikaz liste osoba. Osobe držati u memoriji. Prikaz unutar liste treba prikazati sliku osobe, datum rođenja i eventualno smrti, te kratak opis (1-2 rečenice). Klik na sliku osobe treba prikazati nasumičan citat te osobe. 
	* Pomoć: Osobe možete čuvati u *object* singletonu naziva PeopleRepository koji unutar sebe ima instancu *MutableList* klase. Na repozitoriju omogućiti dodavanje nove osobe.
2. **Zadatak 2.** Riješite zadatak 1. korištenjem fragmenata. Omogućite brisanje osoba iz liste te uređivanje informacija o osobama u listi.
	* Pomoć: Možete koristiti *Viewpager* s dva taba, jedan za prikaz postojećih, drugi za kreiranje novih. Ili možete raditi s FragmentManagerom pa učitavati odgovarajuće fragmente u kontejnerski layout manager unutar Vašeg *Activity*a. U potonjem slučaju koristite *Action* gumb za dodavanje nove osobe.
	* Pomoć: Za uređivanje možete koristiti već postojeći view, samo morate poslati id objekta prilikom otvaranja tog viewa kako bi se učitala postojeća osoba iz repozitorija.
