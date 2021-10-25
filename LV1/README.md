# Laboratorijska vježba 1

## Uvod u Kotlin

Kotlin je moderan objektno orijentiran programski jezik sa statičkom provjerom tipova koji je razvila tvrtka JetBrains. Pogodan je za rješavanje različitih problema i omogućuje izgradnju programske podrške (poslužiteljske aplikacije, mobilne aplikacije, podatkovne znanosti...). 

Za uvod u progamski jezik Kotlin bit će korišteno razvojno okruženje tvrke JetBrains imena Intellij Idea, s obzirom da će se na ovoj vježbi prikazivati čisti Kotlin, bez uplitanja Android razvojnog okvira. Ipak, za razvoj Android aplikacija kasnije će poslužiti Android Studio koji je zasnovan na IntelliJ Idea razvojnom okruženju tako da će usvojeni koncepti biti lako prenosivi u novo razvojno okruženje. IntelliJ Idea besplatan je alat u svom *Community* izdanju i dostupan je na [https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/ "IntelliJ Idea").

## Osnove

### Vrijednosti i varijable

Za razliku od jezika nalik C-u (C++, C\#, Java...) u Kotlinu postoje dvije vrste varijabli. Varijable koje je moguće samo čitati označavaju se ključnom riječju *val* i vrijednost im može biti pridružena samo jednom. Klasične varijable kojima je moguće mijenjati vrijednost po želji označavaju se ključnom riječju *var*. Ove prve će se u ostatku vježbi nazivati vrijednostima, dok će se potonje nazivati varijablama. Preferirano je korištenje vrijednosti tako da ih treba rabiti gdje god je to moguće. Sve vrijednosti i varijable moraju biti inicijalizirane, a pri tome tip nije nužno eksplicitno navoditi već je podržano automatsko određivanje tipa. Ukoliko se želi eksplicitno navesti tip, onda se to radi nakon imena varijable navođenjem znaka *:* i odgovarajućeg tipa.

* [Kako deklarirati varijablu, a kako vrijednost](https://kotlinlang.org/docs/tutorials/kotlin-for-py/declaring-variables.html)
* [Tipovi podataka](https://kotlinlang.org/docs/tutorials/kotlin-for-py/primitive-data-types-and-their-limitations.html)
* [Varijable i tipovi podataka](https://beginnersbook.com/2017/12/kotlin-variables-data-types/)

### Grananja

Grananja u Kotlinu slična su ranije usvojenim u drugim programskim jezicima. Grananje uporabom *if*-a je dostupno i radi na sličan način, ali u Kotlinu je *if* izraz. To znači da vraća vrijednost. Međutim, za razliku od do sada korištenih jezika, Kotlin ne poznaje naredbu *switch*. Umjesto nje dostupna je naredba *when* koja se rabi nešto drugačije. Naime *when* sekvencijalno provjerava dani argument sve dok nije zadovoljen uvjet zadan u nekoj od grana. Umjesto podrazumijevanog slučaja definira se *else*.

* [If grananje](https://kotlinlang.org/docs/tutorials/kotlin-for-py/conditionals.html)
* [When grananje](https://superkotlin.com/kotlin-when-statement/)
* [When grananje - objašnjenje 2](https://www.baeldung.com/kotlin-when)

### Petlje

I u Kotlinu za kontrolu toka programa na raspolaganju stoje petlje. Za iteriranje (slijedni prolazak) kroz kolekcije koje prema van pružaju iterator moguće je koristiti petlju *for* (slična *foreach* u C#-u). Osim *for*-a, na raspolaganju su još *while* i *do .. while* petlje koje rade na uobičajen način.

* [Petlje](https://kotlinlang.org/docs/tutorials/kotlin-for-py/loops.html)
* [while](https://beginnersbook.com/2019/02/kotlin-do-while-loop/)

### Funkcije

Naravno da Kotlin podržava i funkcije, a uz to što je moguće pisati metode (funkcije kao članovi klasa), moguće je pisati i samostalne funkcije (nalik programskom jeziku C++). Sintaksa se razlikuje od ostalih do sada korištenih jezika na FERIT-u. Najprije se navodi ključna riječ *fun*, zatim se navodi ime funkcije (ime mora biti glagol ili počinjati glagolom, mora otkrivati što funkcija/metoda radi!) nakon čega slijedi formalna lista parametara unutar običnih zagrada. Lista parametara može biti i prazna. Nakon toga navodi se *:* i povratni tip funkcije. Funkcija može vratiti samo jednu vrijednost. Što se tiče parametara, podržane su podrazumijevane vrijednosti, imenovani argumenti (kao u Pythonu) te varijabilan broj argumenata.

* [Dokumentacija - funkcije](https://kotlinlang.org/docs/tutorials/kotlin-for-py/functions.html)
* [Primjeri funkcija](https://www.callicoder.com/kotlin-functions/)
* [Struktura funkcija/metoda](https://proandroiddev.com/kotlin-functions-are-fun-8fdcd4e85a5)

## OOP

Kako je Kotlin OO jezik, klase su građani prvog reda. Svi ranije usvojeni koncepti vezani uz OOP (apstrakcija, enkapsulacija, nasljeđivanje i polimorfizam) vrijede i u Kotlinu. Deklaracija klase sastoji se od ključne riječi *class*, imena klase, (opcionalno) zaglavlja klase (navodi se primarni konstruktor) i (opcionalno) tijela klase koje je smješteno u vitičaste zagrade. 	Klase u Kotlinu mogu imati primarni konstruktor i jedan ili više sekundarnih konstruktora. Podrazumijevani konstruktor daje prevoditelj. Primarni konstruktor navodi se u zaglavlju klase. On ne smije sadržavati nikakav kod već se sva inicijalizacija odvija u takozvanim *init* blokovima. Sekundarni konstruktori obavezni su rabiti primarni konstruktor. Instanciranje klase odvija se pozivom konstruktoru, bez ključne riječi *new*.

Klase se, kao i inače, sastoje od stanja i ponašanja. Stanje je opisano podatkovnim članovima, dok je ponašanje opisano funkcijskim članovima. Za razliku od do sada korištenih jezika, u Kotlinu se stanje opisuje svojstvima (nalik na svojstva u C\#-u). Kod korištenja svojstava moguće je koristiti puna svojstva ili automatska. U oba slučaja nije moguće direktno deklarirati atribute koji bi se rabili za pohranu već će ih Kotlin automatski generirati (engl. *backing fields*). Ako je potrebno, atributu je moguće pristupiti korištenjem *field* identifikatora.

Iako je rečeno kako sve u Kotlinu prije korištenja mora biti inicijalizirano, moguće je svojstva klase postaviti i kasnije korištenjem ključne riječi \texttt{lateinit}. Njome će se označiti svojstvo za koje se jamči kako će mu vrijednost biti postavljena prije korištenja.

* [Dokumentacija - klase](https://kotlinlang.org/docs/reference/classes.html)
* [Svojstva i atributi](https://kotlinlang.org/docs/reference/properties.html)
* [Prava pristupa](https://kotlinlang.org/docs/reference/visibility-modifiers.html)
* [Podatkovne klase](https://kotlinlang.org/docs/reference/data-classes.html)
* [Enumi](https://kotlinlang.org/docs/reference/enum-classes.html)
* [Objekti i companion objekti](https://kotlinlang.org/docs/tutorials/kotlin-for-py/objects-and-companion-objects.html)
* [Detaljno o klasama](https://code.tutsplus.com/tutorials/kotlin-from-scratch-classes-and-objects--cms-29590)

### Nasljeđivanje

Kotlin podržava jednostruko nasljeđivanje, moguće je naslijediti samo jednog roditelja. Razlika na dosad susretane pristupe nasljeđivanju leži u činjenici da je kod Kotline podrazumijevano kako je svaka klasa *closed(final)*. Ovime se osigurava to da programer zbilja želi i odgovoran je za to da je neku od njegovih klasa sigurno naslijediti (vidjeti česte probleme kod nasljeđivanja, npr. LSP). 

* [Dokumentacija nasljeđivanja](https://kotlinlang.org/docs/tutorials/kotlin-for-py/inheritance.html)
* [Primjeri nasljeđivanja](https://www.callicoder.com/kotlin-inheritance/)

### Sučelja

Klase u Kotlinu mogu implementirati sučelja. Ideja je jednaka kao i kod drugih, do sada susretanih, jezika. Sučelja definiraju ugovore kojih su se klase dužne držati, a mogu sadržavati deklaracije apstraktnih metoda. Razlika između sučelja i apstraktne klase je u činjenici da sučelja ne mogu držati stanje, jedino mogu sadržavati apstraktna svojstva koja implementirajuća klasa mora prepisati (engl. *override*). 

* [Dokumentacija sučelja](https://kotlinlang.org/docs/reference/interfaces.html)
* [Primjeri sučelja](https://www.baeldung.com/kotlin-interfaces)

### Stringovi

Kao i u Javi, String klasa koristi se za baratanje nizovima znakova. Riječ je o nepromjenjivim objektima što znači da jednom kreiran String nije moguće mijenjati već svaka promjena znači kreiranje novog objekta. Treba stoga biti oprezan prilikom baratanja Stringovima, ukoliko ih se kani često mijenjati. 

Podržani su i predlošci za Stringove, odnosno korištenjem sintakse nalik `"Ovo je string, ali ako želim ubaciti ime psa definirano unutar objekta rex, mogu to napraviti ovako: ${rex.name}"`. 

* [Dokumentacija stringovi](https://kotlinlang.org/docs/tutorials/kotlin-for-py/strings.html)
* [Primjeri rada sa stringovima](https://www.journaldev.com/17318/kotlin-string)

### Null

Kotlin podržava koncept zvan *null safety*. Naime, jedna od najčešćih iznimki koje se sreću u programiranju u jezicima koji imaju null reference je *NullPointerException*. Riječ je u situaciji kada se pokušava rabiti referenca koja nije inicijalizirana, odosno ne pokazuje ni na kakav objekt - null referenca. Kotlinov sustav tipova pokušava eliminirati takve iznimke. 

Sustav tipova razlikuje reference koje mogu biti null i one koje ne mogu. Razlika je u navođenju znaka ? nakon tipa. Ako se koriste članovi tipa koji ne može biti null, onda je sasvim sigurno da do iznimke neće doći. A ako se ista stvar pokuša napraviti na tipu koji može biti null, prevoditelj javlja grešku.

Uz ova svojstva sustava tipova, Kotlin donosi i brojne operatore za siguran rad s nullabilnim referencama, npr. operator sigurnog poziva (?.), elvis operator (?:), operator promjene tipa iz nullabilnog u nenullabilnu inačicu (!!). Također, Kotlin podržava takozvano sigurno pretvaranje tipova (as?). 

* [Null ponašanje u Kotlinu](https://kotlinlang.org/docs/reference/null-safety.html)
* [Najbolje prakse kod null safetya](https://www.raywenderlich.com/436090-null-safety-tutorial-in-kotlin-best-practices)


### Ekstenzije

Kao i u brojnim drugim OOP jezicima, Kotlin također podržava proširenje funkcionalnosti postojećih klasa pisanjem funkcija proširenja. Riječ je o funkcijama koje je moguće pisati čak i za klase čijem izvornom kodu programer nema pristup. Takve funkcije pišu se van same klase, ali ih je moguće pozvati na instancama te klase kao da je riječ o uobičajenim metodama. Kako bi se takva funkcija napisala, njeno ime se proširuje navođenjem klase za koju se piše prije imena funkcije. Važno je napomenuti da načela pisanja čistog koda moraju ostati na umu, neke funkcionalnosti koje nemaju veze s namjerom klase bolje je izdvojiti u posebnu klasu ili slobodnu funkciju najviše razine (*top level function*).

* [Funkcije proširenja - dokumentacija](https://kotlinlang.org/docs/reference/extensions.html)
* [Funkcije proširenja - primjeri](https://www.baeldung.com/kotlin-extension-methods)

### Lambda izrazi

Lambda izrazi i anonimne funkcije su funkcije koje nisu deklarirane već se odmah daju nekom izrazu. Sintaksa lambda izraza jest `val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }`. Vrijednost sum predstavlja funkciju koja kao argumente prima dvije vrijednosti cjelobrojnog tipa, vraća cjelobrojnu vrijednost koja je rezultat operacije zbrajanja argumenata. Parametri se navode prije, a povratni tip i tijelo nakon operatora *->*. Tijelo se nalazi unutar vitičastih zagrada. Lambde i anonimne funkcije se vrlo često predaju metodama kod rada s kolekcijama, osluškivanja na događaje (npr. klik na gumb) i slično. 

* [Lambda izrazi - dokumentacija](https://kotlinlang.org/docs/reference/lambdas.html)
* [Lambda izrazi - primjeri](https://www.baeldung.com/kotlin-lambda-expressions)
* [Lambda izrazi - uvod i korištenje](https://www.raywenderlich.com/2268700-introduction-to-kotlin-lambdas-getting-started)

## Kolekcije

Kotlinova standardna biblioteka omogućuje snažnu podršku za rad s kolekcijama. Ova podrška se očituje u upravljanju kolekcijama neovisno o tome koji konkretan tip elementa se u njoj nalazi. Naime, na kolekcijama je moguće izvršiti brojne radnje poput preslikavanja (map), filtriranja (filter) i slično na vrlo jednostavan način kako bi se manipuliralo podacima koji se u njima nalaze. Uz službenu dokumentaciju (prva poveznica) svakako pogledati barem jedan od preostala dva s primjerima korištenja.

* [Kolekcije - dokumentacija](https://kotlinlang.org/docs/reference/collections-overview.html)
* [Kolekcije - uvod](https://www.raywenderlich.com/4131729-kotlin-collections-getting-started)
* [Pregled kolekcija](https://www.baeldung.com/kotlin-collections-api)


## Dodatni matrijali

* [Kratak uvod u Kotlin](https://www.codemag.com/Article/1907061/Introduction-to-Kotlin)
* [Vježbanje Kotlina - Kotlin Koans](https://play.kotlinlang.org/koans/overview)

## Zadaci
1. Napišite program koji omogućuje igranje igre Jamb (engl. Yahtzee). Poštujte SOLID načela. Poštujte pravila OOP dizajna. Razdvojite funkcionalnost u klase. Treba postojati: 
	- bacanje kockice, provjera stanja
	- igra se sa 6 kockica, omogućiti bacanje svih kockica, zaključavanje 0-6 kockica,	bacanje samo otključanih kockica
	- provjeru rezultata bacanja - podržati barem 3 provjere za jamb (jamb, poker, skala)
	- pogonski program za provjeru napisane funkcionalnosti 
2. Napišite igru BlackJack. Poštujte SOLID načela. Poštujte pravila OOP dizajna. Razdvojite funkcionalnost u klase. Omogućite igranje protiv računala. Računalo mora uzeti novu kartu na 16 i manje. Mora stati na 17 ili više. Prvo igra igrač, zatim igra računalo. As se računalu gleda kao 1 samo ako dovodi do toga da će suma biti veća od 21.
	
