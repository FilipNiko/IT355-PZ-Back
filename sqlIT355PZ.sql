-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2023 at 05:30 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `it355pz`
--

-- --------------------------------------------------------

--
-- Table structure for table `kategorije`
--

CREATE TABLE `kategorije` (
  `id` int(11) NOT NULL,
  `kategorijaNaziv` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kategorije`
--

INSERT INTO `kategorije` (`id`, `kategorijaNaziv`) VALUES
(1, 'Romani'),
(2, 'Pripovetke'),
(3, 'Ljubavni Romani'),
(4, 'Akcija/Avantura'),
(5, 'Trileri/Misterije'),
(6, 'Komedije'),
(7, 'Istorijski Romani'),
(8, 'Fantastika'),
(9, 'Horrori');

-- --------------------------------------------------------

--
-- Table structure for table `knjige`
--

CREATE TABLE `knjige` (
  `id` int(11) NOT NULL,
  `naziv` varchar(100) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `opis` text NOT NULL,
  `idPisma` int(11) NOT NULL,
  `idPoveza` int(11) NOT NULL,
  `brojStrana` int(11) NOT NULL,
  `stanje` int(11) NOT NULL,
  `slikaUrl` text NOT NULL,
  `cena` int(11) NOT NULL,
  `idKategorije` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `knjige`
--

INSERT INTO `knjige` (`id`, `naziv`, `autor`, `opis`, `idPisma`, `idPoveza`, `brojStrana`, `stanje`, `slikaUrl`, `cena`, `idKategorije`) VALUES
(2, 'PARAZIT', 'Artur Konan Dojl', 'Artur Konan Dojl je često koristio zastrašujuće elemente u svojim detektivskim pričama – npr. u Baskervilskom psu – ali, u racionalnom svetu u kojem se sve misterije mogu objasniti, ove elemente jasno ne treba shvatiti ozbiljno. Međutim, čitaoci horora setiće se da je Dojl napisao brojne priče strave u kojima svet nije racionalan, misterija se ne može objasniti, a ono što je zastrašujuće i natprirodno vlada trijumfalno.', 1, 1, 286, 0, 'https://www.knjizare-vulkan.rs/files/watermark/files/images/slike_proizvoda/thumbs_w/366891_w.jpg', 1079, 9),
(3, 'POSLEDNJE PREŽIVELE', 'Arejdi Hendriks', 'Uzbudljiv roman strave i užasa koji prati grupu junakinja na ivici smrti, od sjajnog autora „Njujork tajmsovog” bestselera The Southern Book Club’s Guide to Slaying Vampires. U filmovima strave i užasa, finalna devojka je ona koja živa dočeka odjavnu špicu. Ona koja je uzvratila, pobedila ubicu i osvetila svoje prijatelje. Ona koja, iako ranjena, izlazi kao pobednica. Ali šta se dešava s njom kad se zvuk sirena izgubi u daljini i publika nastavi sa svojim životom?', 1, 2, 312, 1, 'https://dereta.rs/cached/dereta.rs/Images/Poslednje-prezivele0-1000x0-0000129208251157.jpg', 1149, 5),
(4, 'ODLETI', 'Kristin Hana', 'Nekada davno išla sam noću potpuno sama niz mračni put po imenu Ulica svitaca u najgoroj noći u mom životu, i pronašla srodnu dušu. To je bio naš početak. Pre više od trideset godina. Tali-i-Kejt. Ti i ja protiv sveta. Najbolje prijateljice zauvek. Ali priče imaju kraj, zar ne? Izgubiš ljude koje voliš i moraš da pronađeš način da nastaviš dalje...', 1, 2, 392, 1, 'https://www.knjizare-vulkan.rs/files/images/slike_proizvoda/372683.jpg', 669, 3),
(5, 'ĐAVO UVEK NOSI CRNO', 'L. Dž. Šen', 'Medi Goldblum voli život u Njujorku i skrojila je plan kako da sve u njenom životu bude savršeno. Ima posao u modnom studiju za venčanice, kuče na koje je uglavnom alergična i obećavajuću novu romantičnu vezu sa jednim divnim čovekom, pedijatrom.\\n\\nOčigledno je prebolela Čejsa Bleka, bivšeg momka milijardera, koji ju je bacio u vrtlog patnje nakon prevare šest meseci ranije. Ali kad se Čejs pojavi na njenom pragu i saopšti joj da mu otac umire a da mu je on rekao da se verio, Medi iz saosećanja prema starcu nevoljno pristaje da glumi Čejsovu verenicu na porodičnom okupljanju. Ako ništa drugo, makar da vidi kako se Čejs koprca. Naravno, uslediće niz nepredviđenih događaja koji će razbiti u paramparčad plan o savršenom životu s pedijatrom u Njujorku.', 1, 2, 360, 4, 'https://www.laguna.rs/_img/korice/5706/djavo_uvek_nosi_crno-l_dz_sen_v.jpg', 739, 3),
(6, 'RALFOVA OSVETA', 'Delias', 'Ralf Hoton je poticao iz odlične porodice. Njegova majka bila je poslednji potomak stare otmene porodice iz Overnje. Ali osim svoje inženjerske plate, on nije imao nikakvu imovinu. Bio je siroče, bez ikakvih bliskih rođaka, pa je živeo sam sa slugom u malom paviljonu određenom za stanovanje inženjera. Gospođa Sorben je hvalila njegovu ozbiljnost, priznajući pritom da kod njega postoji neka suzdržanost koja nije dopuštala da mu se iko približi. Činilo se da ne želi da mu se neko meša u privatni život.', 1, 2, 200, 11, 'https://www.knjizare-vulkan.rs/files/images/slike_proizvoda/368269.jpg', 809, 3),
(9, 'PUNK 57', 'Penelopi Daglas', 'Ne mogu da se ne nasmešim na ono što je napisala u pismu. Nedostajem joj. Nastavnica u petom razredu povezala nas je sa decom iz druge škole s kojom ćemo se dopisivati. Misleći da sam devojčica, pošto se zovem Miša, druga nastavnica me je spojila sa svojom učenicom Rajen. Misleći da je Rajen dečak, kao i ja, moja nastavnica se složila. Nije nam trebalo mnogo vremena da otkrijemo grešku. A za tili čas raspravljali smo o svemu: gde se naručuju najbolje pice, da li je bolji android ili ajfon, da li je Eminem najbolji reper na svetu… To je bio samo početak. Narednih sedam godina to smo bili mi.', 1, 2, 282, 1, 'https://www.knjizare-vulkan.rs/files/watermark/files/images/slike_proizvoda/thumbs_w/372351_w.jpg', 749, 3),
(10, 'POTAMAN', 'Eni Pru', 'Priče Eni Pru o pokolenjima Amerikanaca koji se bore da opstanu na Zapadu predstavljaju jednu surovu, zaslepljujuću panoramu američke ludosti i usuda. To su priče o modernim kaubojima iz ruralnog dela Vajominga, ali ni u kom slučaju nisu tipične kaubojske priče, budući da u njima nema sukoba na liniji dobro – zlo, a junaci nipošto nisu heroji, nego mali ljudi sputani svojim svakodnevnim nevoljama, počesto začudnim i bizarnim, što pričama daje dodatnu privlačnost i upečatljivost. Oni pokušavaju da se otrgnu od bede i očaja, ali nešto ih uvek sputava i osujećuje, kao da sama zemlja traži njihovu krv.', 1, 1, 230, 2, 'https://www.knjizare-vulkan.rs/files/watermark/files/images/slike_proizvoda/thumbs_w/224228_w.jpg', 669, 2),
(11, 'SLOBODA', 'Grupa autora', 'Ova izuzetna knjiga je antologija kratkih priča koju su napisali neki od najistaknutijih savremenih pisaca inspirisani Opštom deklaracijom o ljudskim pravima koja znamenito počinje sa: „Sva ljudska bića rađaju se slobodna i jednaka.“ Većina priča napisana je posebno za ovu priliku. Svaki pisac je odabrao po jedan član Deklaracije koji mu je poslužio kao moto i nadahnuće za priču. Rezultat je ova izvanredna i očaravajuća zbirka misaonih, ozbiljnih, duhovitih i zabavnih kratkih proznih bravura koje nam ponekad otvaraju sasvim nove poglede na temu o ljudskim pravima. Urađena u saradnji sa organizacijom Amnesty International, Sloboda je delo koje će pobuditi maštu čitalaca i ukazati nam na to koliko nam svima ova prava znače.', 1, 2, 463, 6, 'https://www.knjizare-vulkan.rs/files/images/slike_proizvoda/221611.jpg', 814, 2),
(12, 'UGRIZI', 'Andrej Blatnik', 'Kratke priče Andreja Blatnika - vrsnog majstora ovog žanra - pod mikroskop stavljaju sudbinske trenutke koji raznolike protagoniste drže u procepu. Hoće li hirurzi spasiti mogućeg ubicu svog kolege, koji snajperista će pogoditi metu prvi, dokle seže dodir ispod stola? Učiniti nešto ili ništa, i jedno i drugo podjednako je nemoguće. Odgovornost je utoliko veća što jedna jedina odluka može imati neočekivane posledice ne samo za pojedinca nego i za ceo svet i istoriju, sve do poslednjeg preživelog čoveka, koji se, možda, još zaslepljuje verom da je sve bilo plod puke slučajnosti.', 1, 2, 106, 0, 'https://www.knjizare-vulkan.rs/files/images/slike_proizvoda/360105.jpg', 660, 2),
(13, 'IZGUBLJENA DUŠA', 'Olga Tokarčuk', 'Izgubljena duša je parabola o ubrzanom vremenu, ritmu s kojim ne umemo više da izađemo na kraj, nostalgija za univerzalnim vremenom u kom bismo svi uspeli da se pronađemo. Prikazuje savremenog čoveka koji je izgubio osećaj smisla života, kojem u trku svakodnevice preostaje malo vremena za refleksiju, za postavljanje sebi fundamentalnih pitanja o ispunjenosti u životu.\\nMetafora izgubljene duše je odavno prisutna u kulturi. Olga Tokarčuk, Jungova sledbenica, nadovezuje se na opis sindroma gubitka duše kod njegovih pacijenata, i na svoj način priču poetizuje. Ilustrovana', 1, 2, 48, 5, 'https://www.knjizare-vulkan.rs/files/watermark/files/images/slike_proizvoda/thumbs_w/350859_w.jpg', 1187, 2),
(14, 'ŠPIJUN', 'Danijela Stil', 'U osamnaestoj godini, Aleksandru Vikam su u raskošnoj beloj čipki i satenskoj haljini predstavili kralju Džordžu V i kraljici Meri. Ona je nežna i plavokosa, zapanjujuće lepa, i naizgled je predodređena za privilegovan život. Ali sudbina, svetski rat, i njen tih ali buntovan karakter odvode je drugim putem. Godine 1939. Evropa je u plamenu, a Engleska u ratu. Iz svog doma u idiličnom Hempširu, Aleks odlazi u London kao volonterka u jedinicama Prve pomoći.', 1, 2, 250, 13, 'https://www.knjizare-vulkan.rs/files/images/slike_proizvoda/373623.jpg', 579, 1),
(15, 'LAVOVI SA PETE AVENIJE', 'Fiona Dejvis', 'Godina je 1913. i reklo bi se da Lora Lajons ima sve: njen suprug je nadzornik u Njujorškoj gradskoj biblioteci, žive u najlepšoj zgradi na Menhetnu, blagosloveni sa dvoje dece. Ali uporna i strastvena Lora želi da radi i bude nezavisna. Počinje da piše i objavljuje novinske članke, upoznaje članice kluba Heterodoksi koje se zalažu za pravo žena da glasaju i budu samostalne. A kada vredne knjige nestanu iz biblioteke, preteći da sruše sva njena uverenja, moraće da promeni svoje stavove, rizikujući da izgubi sve.', 1, 2, 320, 11, 'https://www.knjizare-vulkan.rs/files/watermark/files/images/slike_proizvoda/thumbs_w/373592_w.jpg', 989, 1),
(16, 'STRELAC', 'Paulo Koeljo', 'Nekada slavan zbog svoje izuzetne streličarske veštine, Tecuja je izabrao da živi povučeno kao drvodelja u zabačenom selu.', 1, 1, 152, 2, 'https://www.laguna.rs/_img/korice/5711/strelac-paulo_koeljo_v.jpg', 809, 1),
(17, 'TIRANIN BANDERAS', 'Ramon Del Valje Inkla', 'Kultno delo jednog od najznačajnijih španskih pisaca XX veka, koje predstavlja klicu iz koje je kasnije nikao najznačajniji pravac razvoja latinoameričke književnosti uopšte. Ovo je prvi roman o diktaturi, kasnije toliko prisutnoj u Latinskoj Americi, roman koji je postao direktna inspiracija i Markesu za njegovu „Jesen patrijarha“ i Bastosu za „Ja, vrhovni“. Valje-Inklan nam na njemu svojstven način, uz obilje lokalizama i uz pomoć specifičnog narativa, dočarava svu bahatost, drskost, glupost i surovost diktatora koji je prigrabio ne samo civilnu već i svešteničku, vojnu i sudsku vlast. Nešto što nam možda zvuči poznato.', 1, 2, 242, 2, 'https://www.knjizare-vulkan.rs/files/watermark/files/images/slike_proizvoda/thumbs_w/373275_w.jpg', 1320, 1),
(18, 'POGREŠNA PORODICA', 'Tarin Fišer', 'Kad si odrasla osoba, možeš da kontolišeš koga puštašu svoj život, ali ne možeš da kontrolišeš kako će se ponašati kada ih pustiš.\\n\\n\\nDžuno je pogrešila u vezi s Vini Krauč. Pre nego što se uselila kod porodice Krauč, Džuno je mislila da Vini i njen muž Najdžel imaju savršen brak, savršenog sina, savršen život. Tek sad, kad živi u njihovoj predivnoj kući, vidi da je nemoguće zanemariti pukotine na trošnoj fasadi.', 1, 2, 267, 4, 'https://www.delfi.rs/_img/artikli/2021/09/pogresna_porodica_vv.jpg', 809, 4),
(19, 'NESAVRŠENE ŽENE', 'Araminta Hol', 'Kada je Nensi Henesi ubijena, za sobom je ostavila dve najbolje prijateljice, divnog muža, ćerku i ljubavnika, čiji je identitet odnela u grob. Nensi je bila neverovatno lepa, bogata, omiljena u svakom društvu. Njen život je naizgled delovao savršeno. Ali dok istraga o njenoj smrti tapka u mestu, a najbolje prijateljice, Elenor i Meri, hrabro podnose nepremostivi gubitak, na površinu izbijaju mračni detalji koji otkrivaju koliko su malo znale o svojoj prijateljici, jedna o drugoj, a možda i o sebi samima.', 1, 2, 326, 11, 'https://dereta.rs/cached/dereta.rs/Images/Nesavrsene-zene0-1000x0-0000129206124232.jpg', 899, 4),
(20, 'NJENA AFRIČKA AVANTURA', 'Tejlor Stivens', 'Mogu da osetim tvoj strah i čujem laž u tvom glasu. Znam tvoje slabosti i neću se ustručavati da ih iskoristim. Ja sam kameleon i lovac. Živela sam u osamnaest država, imam tri pasoša i govorim dvadeset dva jezika. Ubijala sam mnogo. To se ne očekuje od deteta rođenog u misionarskoj porodici u Africi, ali radila sam sve što je bilo potrebno da bih preživela.', 1, 2, 202, 1, 'https://www.knjizare-vulkan.rs/files/watermark/files/images/slike_proizvoda/thumbs_w/243759_w.jpg', 594, 4),
(21, 'TRAGOM SVETOG GRALA', 'Nelson de Mil', 'Uzbudljiva avantura za sva čula vodi čitaoca od prekrasnih vrtova Vatikana i kapija velelepnog Rima sve do samog srca vrelih džungli Etiopije.\\n\\nDok građanski rat u Etiopiji ne jenjava, stari katolički sveštenik Đuzepe sedi u zatvorskoj ćeliji. Prošlo je dugih četrdeset godina od kada je poslednji put ugledao svetlost dana. A onda, nakon što je izgubio svaku nadu, bombaški napad Đuzepeu pruža priliku za beg.', 1, 2, 376, 2, 'https://www.knjizare-vulkan.rs/files/watermark/files/images/slike_proizvoda/thumbs_w/279935_w.jpg', 849, 4),
(22, 'ŠAPTAČ', 'Donato Karizi', 'Ne pomaže ti da znaš kako. Ne vredi ti da shvatiš zašto. Nije ti dovoljno da otkriješ ko. On je već korak ispred.\\n\\nOtkiven je stravičan zločin: šest odsečenih ruku poređano je u misteriozan krug i zakopano na proplanku u šumi. Pet pripada devojkama koje se vode kao nestale. Šesta ruka tek treba da bude identifikovana. Najstrašnije od svega jeste to što tela devojaka, bilo da su žive ili mrtve, nigde nisu pronađena.', 1, 2, 360, 13, 'https://www.knjizare-vulkan.rs/files/watermark/files/images/slike_proizvoda/thumbs_w/248064_w.jpg', 699, 5),
(23, 'GAJGER', 'Gustaf Šerderman', 'Otišla je do tajnog skrovišta i izvukla veliki crni pištolj\\nsa prigušivačem. Približila se svom mužu otpozadi i\\nprislonila mu cev na glavu. Onda je povukla obarač.\\nMlaz krvi poteče na knjigu, koja odmah ispade iz\\nStelanovih ruku. Geteov Faust na originalnom\\nnemačkom.\\nNeobično ubistvo nije slučaj Sare Novak. Ali njene\\nkolege znaju da je ona odrasla sa Bromanovima i da\\nih poznaje bolje od bilo koga. Pridružuje se istrazi\\nkoja će je dovesti do zapanjujućih otkrića o pravom\\nidentitetu i mračnoj prošlosti ljudi koje smatrala\\nsvojom porodicom. A tajanstvena reč samo je prvi\\ndelić slagalice zamršene zavere stvorene pola veka\\nranije.', 1, 2, 352, 2, 'https://www.vulkani.rs/files/images/slike_proizvoda/25717.jpg', 499, 5),
(24, 'TIHI PACIJENT', 'Aleks Mihaelides', 'Te kobne noći, stajala je u beloj haljini, nakon što je ispalila pet hitaca. Nije rekla ni reč. Nije odgovarala na pitanja. Nije mogla, a nije ni htela da govori. Čak i kad je optužena za ubistvo supruga. Ćutala je i kad je uhapšena. Odbijala je da prizna ili porekne krivicu. Nikad nije progovorila.', 1, 2, 272, 5, 'https://www.knjizare-vulkan.rs/files/watermark/files/images/slike_proizvoda/thumbs_w/338346_w.jpg', 699, 5),
(25, 'PISMO GLAVA', 'Džefri Arčer', 'Od ranog detinjstva je bilo jasno da je Aleksandar Karpenko predodređen za velike stvari. Ali kad njegovog oca ubije KGB zbog pokušaja sindikalnog organizovanja, Aleksandar i njegova majka moraju da pobegnu iz Rusije ako žele da prežive. Kad stignu u luku u dogovoreni čas, nađu se pred nepovratnim izborom: ukrcati se ili na teretni brod za Ameriku, ili na teretni brod za Veliku Britaniju. Aleksandar taj izbor prepušta bacanju novčića.', 1, 2, 544, 2, 'https://www.knjizare-vulkan.rs/files/images/slike_proizvoda/368272.jpg', 1709, 7),
(26, 'PRIČA O ZEMLJI I MORU', 'Kejti Simpsons Smit', 'Pričom koja se odigrava u malom primorskom mestu u Severnoj Karolini, u godinama kada se Američka revolucija već bliži kraju, ovaj briljantni roman prati tri generacije jedne porodice, junake koji žude za iskupljenjem usred omamljujućeg vrtloga rata, otmica, ropstva i ljubavi.\\n\\nDžon, gusar koji se zbog ljubavi vezao za kopno vraća se na more u nadi da će morska so izlečiti njegovu kćer Tabitu od smrtonosne žute groznice.\\n\\nGodinama ranije, njegova žena Helen gazi sve konvencije i želje pobožnog oca Ejse, kako bi se udala za ozloglašenog gusara Džona načinivši time odluku koja će im svima promeniti živote.', 1, 2, 264, 3, 'https://www.laguna.rs/_img/korice/2527/prica_o_zemlji_i_moru-kejti_simpson_smit_v.jpg', 674, 7),
(27, 'LUČONOŠE', 'Rouzmari Satklif', 'Poslednji deo najprodavanije trilogije o rimskoj Britaniji započete romanom Orao devete legije, a nastavljene romanom Srebrna grana.\\n\\nIz Britanije su zauvek otplovili poslednji rimski vojnici i prepustili je građanskom ratu i opasnosti od saksonske najezde.\\nAkvila napušta svoj puk i vraća se porodici, ali u ruševinama zatiče i svoj dom i sve što je voleo. Posle mnogo godina teškog rada i odricanja, Akvilu na kraju samo jedno održava u životu – želja za osvetom...', 1, 2, 368, 7, 'https://www.laguna.rs/_img/korice/1912/luconose-rouzmari_satklif_v.jpg', 788, 7),
(28, 'M SIN VEKA', 'Antonio Skurati', 'On je poput zveri: oseća vreme koje dolazi. Nanjušio ga je. Nanjušio je iscrpljenu Italiju, umornu od demokratije u agoniji i nesposobnih političara koji učestvuju u njenoj propasti. Zato se stavlja na čelo paravojnih milicija, prestupnika, palikuća i „čistokrvnih fašista“, koji su najopasniji i najsuroviji. U izveštaju Službe državne bezbednosti iz 1919. opisan je kao „inteligentan, snažne građe, iako boluje od sifilisa, sladostrastan, emotivan, smeo, neko kome se ljudi na prvi pogled dopadnu ili ne dopadnu“. On je Benito Musolini, bivši socijalistički vođa izbačen iz partije, neumorni politički agitator, direktor malog opozicionog lista.', 1, 2, 744, 3, 'https://www.laguna.rs/_img/korice/4981/m_sin_veka-antonio_skurati_v.jpg', 1259, 7),
(29, 'USPON MRAKA', 'K. S. Pakat', 'Bežeći od ljudi koji su mu ubili majku, Vil postaje deo sasvim drugačijeg sveta. Sveta u kojem postoji magija. Sveta u kojem mora da vežba do iznemoglosti da bi odigrao ključnu ulogu u predstojećoj borbi protiv Mraka. Dok London iščekuje povratak Mračnog kralja, a mladi ratnici Svetla i Mraka traže svoje mesto u ratu koji se bliži, heroji i zlikovci iz starih legendi vraćaju se da se ponovo sretnu na bojnom polju. U njihovim se dušama bude davnašnje strasti, davnašnja neprijateljstva… i plamen ljubavi, jači i od večnosti', 1, 2, 352, 3, 'https://www.knjizare-vulkan.rs/files/watermark/files/images/slike_proizvoda/thumbs_w/366052_w.jpg', 1019, 8),
(30, 'IZ ČISTA MIRA', 'Džo Aberkrombi', 'Mir je samo drugačija vrsta bojišta... Savina dan Glokta, nekada najmoćnija poslovna žena Adove, shvata da su njena sposobnost procene, ugled i bogatstvo ozbiljno načeti. Svejedno, neće odustati od svojih ogromnih ambicija, i nikakvi obziri je neće sprečiti da ih ostvari.\\n\\nZa junake poput Lea dan Broka i Staura Mračnog, ljude srećne jedino kad u ruci drže mač, mir predstavlja mučenje koje treba okončati što je pre moguće. Zato stare mržnje treba razbuditi, nove saveznike pronaći, dok nova vladarka Afrita mora da ovlada dugim okom… pre nego što je ono ubije.', 1, 2, 559, 5, 'https://www.laguna.rs/_img/korice/5483/iz_cista_mira-dzo_aberkrombi_v.jpg', 1709, 8),
(31, 'CAREVA DUŠA', 'Brendon Sanderson', 'Kada Šai uhvate na delu dok mesečevo žezlo zamenjuje svojom besprekornom krivotvorinom, ona mora da se pogađa i pregovara kako bi sačuvala živu glavu.\\n\\nNakon napada plaćenog ubice, car Ašravan osta je bez svesti, što su okolnosti koje je prikrila samo pogibija njegove supruge. Ako se car ne pojavi u javnosti po isteku stodnevne žalosti, Tekovinska frakcija će ostati bez vlasti, a carstvom će zavladati haos.', 1, 1, 157, 9, 'https://www.delfi.rs/_img/artikli/2022/11/careva_dusa_vv.jpg', 1350, 8),
(32, 'BORN', 'Džef Vandermer', 'U razrušenom, bezimenom gradu budućnosti, jedna mlada žena po imenu Rejčel, koja živi od sakupljanja bilo čega što bi moglo biti korisno, u krznu Morda, džinovskog letećeg medveda, despota njihovog sveta, pronalazi upetljano stvorenje i daje mu ime Born. Isprva Born ne liči ni na šta – tek zelenkasta grudva nečega što bi prosto moglo biti samo Kompanijin biotehnološki otpad, ali on Rejčel podseća na ostrvo na kom je rođena, sada davno nestalo pod morem. Oseća neku vezu s njim koju poriče, jer veze su zamke, a u njenom svetu svaka slabost može značiti smrt. Ipak donosi Borna u Balkonski greben, podzemno sklonište gde živi sa Vikom, dilerom koji prodaje sećanja, jedini beg iz jalovog, pobeđenog i slomljenog grada. Rejčel uspeva ubediti Vika da ne iskoristi Borna kao sirovi genetski materijal u svojoj laboratoriji. Šta je Born?', 1, 1, 330, 3, 'https://www.knjizararoman.rs/__public/upload/2021/05/25/knjiga-born-dzef-vandermer-orfelin-knjizara-roman-foto2-77901.jpg', 1584, 8),
(33, 'KNJIGA EJBONOVA', 'Klark Ešton Smit', 'Knjiga Ejbonova Klarka Eštona Smita manje je poznata sestra bliznakinja Nekronomikona H. F. Lavkrafta.', 1, 1, 460, 7, 'https://www.knjizare-vulkan.rs/files/watermark/files/images/slike_proizvoda/thumbs_w/359560_w.jpg', 2475, 9),
(34, 'PREDSKAZANJE', 'Dejvid Selcer', 'Džeremi Torn i njegova supruga Ketrin upravo su poželeli dobrodošlicu na ovaj svet najnovijem članu porodice, predivnom sinu Dejmijenu. Ali užas oko dečaka raste naporedo s njim. Izgleda da nesreće s kobnim ishodom, samoubistva i neobjašnjivo nasilje prate Tornove na svakom koraku – ali zašto? I kako Dejmijen može da ima bilo kakve veze s takvim krvoprolićem i stradanjima? On je samo dete…', 1, 1, 240, 3, 'https://www.vulkani.rs/files/images/slike_proizvoda/24051.jpg', 1019, 9),
(35, 'FANTOMSKI LJUBAVNIK', 'Vernon Li', 'Vernon Li je pseudonim Vajolet Pedžet (1856 – 1935), koju su savremenici nazivali “najumnijom Evropljkankom”. Tek mali deo njenog opusa – bavila se prvenstveno istorijom evropske umetnosti od renesanse pa naovamo – posvećen je književnosti strave, zapravo veoma neobičnim pričama o duhovima, ali su te priče prava remek-dela žanra. „Niko od nas ne veruje u duhove kao u logičke mogućnosti, nego ih većina među nama zamišlja kao imaginativne mogućnosti; i dalje možemo da osetimo ono sablasno, pa je prema tome sablast jedina stvar koja u bilo kom smislu može za nas da zameni drevna božanstva i omogući nam da razumemo, makar i samo na minut, imaginativnu moć koju su ona posedovala, a koju su im preoteli ne samo logika nego i umetnost.', 1, 1, 356, 3, 'https://www.knjizare-vulkan.rs/files/watermark/files/images/slike_proizvoda/thumbs_w/363461_w.jpg', 1485, 9),
(36, 'KAKO NOVČIĆ KAŽE', 'Džejms Bejli', 'Ko kaže da se ne može sve prepustiti slučaju?\\n\\nOn je voli! Šta može krenuti po zlu?\\nNovogodišnje je veče. Oni su u kabini Londonskog oka. On je prosi. Sve je savršeno.\\n\\nAli ona kaže NE.\\nI vožnja traje još jezivih dvadeset devet minuta u potpunoj tišini.\\n\\nA onda je sve pošlo od lošeg na gore pošto je Džoš izgubio posao i vratio se u Bristol da živi kod svojih roditelja. Ubeđen da ne ume samostalno da donosi ispravne odluke, rešava da sledećih godinu dana, svaki put kad se nađe u nedoumici ili mora o nečemu važnom da se izjasni, baci novčić.', 1, 2, 308, 3, 'https://www.delfi.rs/_img/artikli/2021/04/kako_novcic_kaze_vv.jpg', 809, 6);

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`id`, `username`, `email`, `password`) VALUES
(1, 'FilipN', 'filip@gmail.com', 'filipfilip'),
(4, 'admin', 'admin@gmail.com', '$2a$10$d8.j3N4iTSHXVdCFkWU/S.azGy1gA/oFguhnIvP6JJ6vu.qLkbW.q'),
(5, 'user', 'user@gmail.com', '$2a$10$bI77YVJ9OXLTuOoYCmbLoOcdBXeE7Iampk7hsV4Bo8NTQwsj2cAMa'),
(6, 'FilipNiko', 'filipniko@gmail.com', '$2a$10$k1gcU7XJ4cht7MT7T/8iourHspVmJQnD8JVWBfQmgGWvVOYTuPHAG'),
(7, 'MarkoM', 'marko@gmail.com', '$2a$10$SClU/N52sSOiodO4c4AtAuEtsKfWkqua54wtzpPaSr0KXavmha7Tq'),
(8, 'Radivoje', 'radivoje@gmail.com', '$2a$10$vXXh0RzxepOkFm7wHczKD.fFPUb62Br3J.5vV1xkZ4gat/H8FB19C');

-- --------------------------------------------------------

--
-- Table structure for table `pisma`
--

CREATE TABLE `pisma` (
  `id` int(11) NOT NULL,
  `pismo` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pisma`
--

INSERT INTO `pisma` (`id`, `pismo`) VALUES
(1, 'latinica'),
(2, 'ćirilica');

-- --------------------------------------------------------

--
-- Table structure for table `porudzbine`
--

CREATE TABLE `porudzbine` (
  `id` int(11) NOT NULL,
  `datumKreiranja` varchar(30) NOT NULL,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `grad` varchar(50) NOT NULL,
  `adresa` varchar(50) NOT NULL,
  `zip` varchar(50) NOT NULL,
  `brTelefona` varchar(30) NOT NULL,
  `idStatusa` int(11) NOT NULL,
  `idKorisnika` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `porudzbine`
--

INSERT INTO `porudzbine` (`id`, `datumKreiranja`, `ime`, `prezime`, `grad`, `adresa`, `zip`, `brTelefona`, `idStatusa`, `idKorisnika`) VALUES
(1, '10/10/2022', 'Filip', 'Nikolic', 'Zlatibor', 'Adresa1', '31315', '3213', 3, 1),
(3, '10/10/2022', 'Filipp', 'Nikolicc', 'Zlatibor', 'Adresa1', '31315', '3213', 4, 1),
(4, '2023/06/11', 'Ime', 'Prezime', 'Adresa1', 'Grad1', '131', '21212', 1, 1),
(5, '2023/06/12', 'Marko', 'Markovic', 'Beograd', 'Neka', '1234', '1234123', 2, 5),
(6, '2023/06/12', 'Radivoje', 'Radivojevic', 'Grad', 'Adr', '123', '1233', 1, 5),
(8, '2023/06/12', 'Filip', 'Nikolic', 'Grad1', 'Adresa', '1234', '123', 1, 5),
(9, '2023/06/12', 'Filip', 'Nikolic', 'Zlatibor', 'Adresa 36', '31315', '983465353', 4, 6),
(10, '2023/06/12', 'Marko', 'Markovic', 'Nis', 'Adres Neka 10', '18000', '42342344', 3, 7),
(11, '2023/06/13', 'Radivoje', 'Radivojevic', 'Cacak', 'Neka Adresa 23', '31000', '124238554', 3, 8);

-- --------------------------------------------------------

--
-- Table structure for table `povez`
--

CREATE TABLE `povez` (
  `id` int(11) NOT NULL,
  `vrsta` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `povez`
--

INSERT INTO `povez` (`id`, `vrsta`) VALUES
(1, 'Tvrdi'),
(2, 'Broš'),
(3, 'Meki');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `naziv` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `naziv`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `statusi`
--

CREATE TABLE `statusi` (
  `id` int(11) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `statusi`
--

INSERT INTO `statusi` (`id`, `status`) VALUES
(1, 'Kreirana'),
(2, 'Isporuka'),
(3, 'Završena'),
(4, 'Otkazana');

-- --------------------------------------------------------

--
-- Table structure for table `stavke`
--

CREATE TABLE `stavke` (
  `id` int(11) NOT NULL,
  `idPorudzbine` int(11) NOT NULL,
  `idKnjige` int(11) NOT NULL,
  `brojPrimeraka` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stavke`
--

INSERT INTO `stavke` (`id`, `idPorudzbine`, `idKnjige`, `brojPrimeraka`) VALUES
(1, 1, 31, 1),
(2, 1, 13, 2),
(3, 4, 4, 1),
(4, 4, 5, 1),
(5, 5, 5, 2),
(6, 5, 3, 1),
(7, 6, 3, 1),
(8, 6, 5, 1),
(15, 8, 25, 1),
(16, 8, 27, 4),
(17, 8, 26, 1),
(18, 9, 33, 2),
(19, 9, 35, 1),
(20, 10, 35, 1),
(21, 10, 36, 1),
(22, 11, 23, 2),
(23, 11, 24, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(4, 1),
(5, 1),
(4, 2),
(6, 1),
(7, 1),
(8, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kategorije`
--
ALTER TABLE `kategorije`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `knjige`
--
ALTER TABLE `knjige`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idKategorijeFK` (`idKategorije`),
  ADD KEY `idPismaFK` (`idPisma`) USING BTREE,
  ADD KEY `idPovezaFK` (`idPoveza`) USING BTREE;

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `pisma`
--
ALTER TABLE `pisma`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `porudzbine`
--
ALTER TABLE `porudzbine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idKorisnikaFK` (`idKorisnika`) USING BTREE,
  ADD KEY `idStatusaFK` (`idStatusa`) USING BTREE;

--
-- Indexes for table `povez`
--
ALTER TABLE `povez`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `statusi`
--
ALTER TABLE `statusi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stavke`
--
ALTER TABLE `stavke`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPorudzbineFK` (`idPorudzbine`) USING BTREE,
  ADD KEY `idKnjigeFK` (`idKnjige`) USING BTREE;

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD KEY `user_roles_ibfk_1` (`role_id`),
  ADD KEY `user_roles_ibfk_2` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kategorije`
--
ALTER TABLE `kategorije`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `knjige`
--
ALTER TABLE `knjige`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `korisnici`
--
ALTER TABLE `korisnici`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `pisma`
--
ALTER TABLE `pisma`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `porudzbine`
--
ALTER TABLE `porudzbine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `povez`
--
ALTER TABLE `povez`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `statusi`
--
ALTER TABLE `statusi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `stavke`
--
ALTER TABLE `stavke`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `knjige`
--
ALTER TABLE `knjige`
  ADD CONSTRAINT `knjige_ibfk_1` FOREIGN KEY (`idKategorije`) REFERENCES `kategorije` (`id`),
  ADD CONSTRAINT `knjige_ibfk_2` FOREIGN KEY (`idPisma`) REFERENCES `pisma` (`id`),
  ADD CONSTRAINT `knjige_ibfk_3` FOREIGN KEY (`idPoveza`) REFERENCES `povez` (`id`);

--
-- Constraints for table `porudzbine`
--
ALTER TABLE `porudzbine`
  ADD CONSTRAINT `porudzbine_ibfk_1` FOREIGN KEY (`idKorisnika`) REFERENCES `korisnici` (`id`),
  ADD CONSTRAINT `porudzbine_ibfk_2` FOREIGN KEY (`idStatusa`) REFERENCES `statusi` (`id`);

--
-- Constraints for table `stavke`
--
ALTER TABLE `stavke`
  ADD CONSTRAINT `stavke_ibfk_1` FOREIGN KEY (`idKnjige`) REFERENCES `knjige` (`id`),
  ADD CONSTRAINT `stavke_ibfk_2` FOREIGN KEY (`idPorudzbine`) REFERENCES `porudzbine` (`id`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `korisnici` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
