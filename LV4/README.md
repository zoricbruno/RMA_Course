# Laboratorijska vježba 4 - Organizacija koda i arhitektura aplikacije

## Organizacija koda

* [Struktura projekta - dokumentacija](https://developer.android.com/studio/projects)
* [Kotlin style guide](https://developer.android.com/kotlin/style-guide)
* [Kotlin practices](https://phauer.com/2017/idiomatic-kotlin-best-practices/)
* [Kako organizirati projekt](https://medium.com/@andycherkashyn/how-to-organize-android-project-files-the-right-way-46b34289ad0a)
* [Najbolje prakse](https://github.com/futurice/android-best-practices)
* [Alati za pomoć pri developmentu](https://techbeacon.com/app-dev-testing/code-pro-31-tools-android-app-developers)
* [Naming guidelines](https://github.com/ribot/android-guidelines/blob/master/project_and_code_guidelines.md)

## Data binding

Android pruža podršku za pisanje deklarativnih sučelja korištenjem principa koji se naziva *vezanje podataka* (engl. *data binding*). Ideja iza ovoga jest da se unutar xml datoteke koja predstavlja izgled aplikacije naznači podatak s kojim je element sučelja povezan te da se na promjenu podataka automatski osvježi prikaz na sučelju. Do sada se svaka promjena morala eksplicitno definirati u kodu. Kako bi se podržao *data binding*, android generira *Binding* klasu na temelju *layouta* kojeg ste nadopunili ranijim oznakama podataka. Ova klasa dobiva ime prema imenu layout datoteke s *Binding* sufiksom (npr. MainActivityBinding). Referencu na nju moguće je dobiti preko DataBinidingUtil klase koja će u ovom slučaju napuhati layout iz XML-a. Da biste se upoznali s konceptom data bindinga, proučite sljedeće materijale
* **[Obavezno]** [Pročitati dokumentaciju](https://developer.android.com/topic/libraries/data-binding)
* **[Obavezno]** [Proći kroz codelab](https://codelabs.developers.google.com/codelabs/kotlin-android-training-data-binding-basics/#0)
* **[Dodatno]** [RW - Data binding tutorijal](https://www.raywenderlich.com/7711166-data-binding-in-android-getting-started)
* **[Dodatno]** [Vogella - data binding](https://www.vogella.com/tutorials/AndroidDatabinding/article.html)



## View modeli i live data

Podaci koji se čuvaju unutar komponente koja predstavlja UI (npr. *activity*), a koji predstavljaju neko stanje potrebno sučelju neće preživjeti rotaciju ekrana (promjenu konfiguracije). Sjetite se da u tom slučaju aktivnost biva uništena i ponovno stvorena, prolazeći tako kroz niz faza životnog ciklusa. Još jedan primjer mogućih problema predstavljaju i zahtjevi prema udaljenim resursima. Ako zahtjev traje dulje, upitno je je li UI komponenta i dalje prisutna. ViewModel je klasa dizajnirana da upravlja upravo takvim podacima i situacijama, ali uz svijest o životnom ciklusu UI komponente. Dio je Android arhitekturalnih komponenti i veći dio navedenog omogućuje automatski. Kako biste se upoznali s ViewModelima, proučite

* **[Obavezno]**  [Dokumentacija](https://developer.android.com/topic/libraries/architecture/viewmodel)
* **[Obavezno]**  [View Model Lyla Fujiwara](https://www.youtube.com/watch?v=5qlIPTDE274)
* **[Obavezno]**  [Jednostavan primjer (Java, ali vrlo jednostavno prebaciti u Kotlin)](https://medium.com/androiddevelopers/viewmodels-a-simple-example-ed5ac416317e)


Live data je klasa za držanje podataka koju je moguće promatrati (engl. *observable*). Bitna stvar jest činjenica da je svjesna životnog ciklusa aktivnosti, fragmenata i servisa. Ovo omogućuje da se ažurira stanje samo onih komponenti (promatrača) koji su trenutno aktivni (started ili resumed). U kombinaciji s ViewModelima i Data Bindingom omogućuje vrlo fleksibilan dizajn prezentacijskog dijela aplikacije. 

* **[Obavezno]** [Dokumentacija](https://developer.android.com/topic/libraries/architecture/livedata)
* **[Obavezno]** [Live data, Lyla Fujiwara](https://www.youtube.com/watch?v=OMcDk2_4LSk)
* **[Obavezno]** [Jednostavan primjer rada LiveData](https://medium.com/elye.project/understanding-live-data-made-simple-a820fcd7b4d0)

## Kako pomiriti sve navedeno:
* **[Dodatno]** [Fun with LiveData](https://www.youtube.com/watch?v=2rO4r-JOQtA&t=496s)
* **[Dodatno]** [Što je MVVM i kako radi](https://www.raywenderlich.com/636803-mvvm-and-databinding-android-design-patterns) 
* **[Dodatno]** [Codelabs 5.1 - 5.4](https://codelabs.developers.google.com/codelabs/kotlin-android-training-view-model/index.html?index=..%2F..android-kotlin-fundamentals#0)
* **[Dodatno]** [Mini MVVM aplikacija](https://www.youtube.com/watch?v=d7UxPYxgBoA)
* **[Dodatno]** [Kompletna MVVM aplikacija](https://www.youtube.com/watch?v=yDaaM3u389I&list=PLB6lc7nQ1n4jTLDyU2muTBo8xk0dg0D_w)


## Zadaci
1. **Zadatak 1.** Riješiti zadatak s promatranjem ptica iz LV3 korištenjem data bindinga, viewmodela i live data. *Pomoć - [primjer](https://proandroiddev.com/architecture-components-modelview-livedata-33d20bdcc4e9)*
2. **Zadatak 2.** Proći kroz https://blog.mindorks.com/mvvm-architecture-android-tutorial-for-beginners-step-by-step-guide i izraditi aplikaciju iz primjera.