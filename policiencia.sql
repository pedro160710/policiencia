-- phpMyAdmin SQL Dump
-- version 4.0.10.10
-- http://www.phpmyadmin.net
--
-- Servidor: 127.7.189.2:3306
-- Tiempo de generaciÛn: 17-07-2015 a las 17:44:06
-- VersiÛn del servidor: 5.5.41
-- VersiÛn de PHP: 5.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `policiencia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE IF NOT EXISTS `autor` (
  `id_autor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_autor` varchar(80) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
  `apellido_autor` varchar(80) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
  PRIMARY KEY (`id_autor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`id_autor`, `nombre_autor`, `apellido_autor`) VALUES
(1, 'Paulo', 'Cohelo'),
(2, 'David', 'Escamilla'),
(3, 'Fransesc', 'Miralles'),
(4, 'Fransesc', 'Miralles'),
(5, 'luis', 'galindo'),
(6, 'Juan', 'Gelman'),
(7, 'Ernesto', 'kahan'),
(8, 'Gabriel', 'Garcia Marquez'),
(9, 'Ana MAria', 'Matute');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_categoria` varchar(50) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=24 ;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nombre_categoria`) VALUES
(1, 'Antologia'),
(2, 'Arquitectura'),
(3, 'Aventuras'),
(4, 'Ciencias Ocultas'),
(5, 'Cine'),
(6, 'Comercio'),
(7, 'Comunicacion'),
(8, 'Derecho'),
(9, 'Digital'),
(10, 'Educacion'),
(11, 'Feminismo'),
(12, 'Historia'),
(13, 'Informatica'),
(14, 'Marketing'),
(15, 'Novela'),
(16, 'Otros'),
(17, 'Poesia'),
(18, 'Religion'),
(19, 'Sociologia'),
(20, 'Teatro'),
(21, 'Television'),
(22, 'Urbanismo'),
(23, 'Viajes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE IF NOT EXISTS `libro` (
  `id_libro` int(11) NOT NULL AUTO_INCREMENT,
  `id_categoria` int(11) DEFAULT NULL,
  `id_autor` int(11) DEFAULT NULL,
  `titulo_libro` varchar(50) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
  `precio_libro` decimal(5,2) NOT NULL,
  `sinopsis_libro` text CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
  `ruta_imagen_libro` varchar(128) CHARACTER SET latin1 COLLATE latin1_general_cs NOT NULL,
  `stock_libro` int(11) NOT NULL,
  PRIMARY KEY (`id_libro`),
  KEY `fk_relationship_1` (`id_categoria`),
  KEY `fk_relationship_2` (`id_autor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27 ;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id_libro`, `id_categoria`, `id_autor`, `titulo_libro`, `precio_libro`, `sinopsis_libro`, `ruta_imagen_libro`, `stock_libro`) VALUES
(1, 23, 9, 'las mil y una noches', '4.50', 'Amuhd dajal es una persona en un pais extranjero y se conoce con amelia...', '/Imagenes/lorca.PNG', 50),
(2, 22, 8, 'El ultimo borbon', '25.00', 'En esta antologÌ≠a de ucronas se especula sobre realidades alternativas ficticias, desde la familia de Aznar convertida en familia real, hasta la recuperaciÛn en un futuro lejano del cerebro del monarca, crionizado siglos atr·s, pasando por una trama paralela del Golpe de Estado del 23-F o un tiempo futuro en que EspaÒa estar·? colonizada por Alemania, entre otros futuros posibles. ', '/Imagenes/elUltimoBorbon.jpg', 58),
(3, 21, 7, 'El absurdo fin de la realidad', '15.17', 'El absurdo fin de la realidad cuenta la inminente llegada de un ovni a un pueblo mediterr·neo y la preparaciÛn de sus habitantes para recibir a los visitantes alienÌ≠genas. El narrador relata cÌmo prepara un discurso de bienvenida para los extraterrestres, salpicando anÈcdotas, reflexiones sobre literatura, filosof?≠a, cine, humor, necrofilia rom??ntica y chascarrillos vecinales a partes iguales. Pero a medida que el d?≠a de la llegada del platillo se acerca, las cosas se complican. Fen?≥menos extra??os comienzan a ocurrir en el pueblo: saltos en el tiempo, aparici?≥n de misteriosas puertas que comunican con otras dimensiones, visiones estramb?≥ticas y un final delirante e inesperado que dar?? un giro a toda la novela hasta convencernos de que la realidad no es m??s que un espejismo, un teatro del absurdo. ¬?Una s??tira de Bienvenido, Mister Marshall en la Espa??a de un futuro probable que sigue siendo la misma? Algo de ello hay. \n', '/Imagenes/elAbsurdoFinDeLaRealidad.jpg', 100),
(4, 20, 6, 'Titanes', '18.45', 'Titanes una novela de ciencia ficciÛn basada en unos de los hechos que m??s conmovieron a Am?(C)rica. En 1972, en los Andes, seestrell?≥ un avi?≥n en las monta??as. Se les dio por muertos, pues no ten?≠an apenas alimentos con los que sobrevivir. Pero hubo supervivientes, catorce personas que aguantaron comiendo los cad??veres de los muertos. Algo m??s de un siglo despu?(C)s, en 2099, la nave espacial Cassini sufre un accidente en Tit??n, el sat?(C)lite de Saturno. Sobre las nieves de metano y amon?≠aco, a 180 grados bajo cero, los supervivientes han de hacer comerse a sus muertos hasta que llegue el rescate desde la Tierra.', '/Imagenes/Titanes.jpg', 45),
(5, 19, 5, 'libro del futbol', '18.45', 'Relatos de: Mario Benedetti, Arnold Bennett, Calder?≥n de la Barca, Lewis Carroll, Camilo Jos?(C) Cela, Mario Cuenca Sandoval, Homero, Wenceslao Fern??ndez Florez, Roberto Fontanarrosa, Manuel Hidalgo, Vladimir Nabokov, Santiago Segurola, William Shakespeare, Osvaldo Soriano, Manuel V??zquez Montalb??n y Coradino Vega.', '/Imagenes/libroDelFutbol.jpg', 21),
(6, 18, 4, 'SFO', '18.54', 'El imaginario colectivo ha fijado ciertas metr?≥polis como iconos de un tiempo y una ?(C)poca. De esta manera, pocos enclaves sintetizan mejor la idiosincrasia del momento actual que la singular San Francisco. En este libro, el dise??ador Jos?(C) Luis R. Torrego y el poeta Pablo Luque Pinilla retratan la ciudad y se ensimisman con sus personajes a partir de un di??logo cuyo resultado es un viaje l??cido y atractivo por el mapa de las inquietudes y preocupaciones que nos son propias.', '/Imagenes/SFO.jpg', 12),
(7, 17, 3, '50 miradas de espaÒa', '81.50', 'El famos?≠simo fot?≥grafo Luis Gaspar junto con uno de los colaboradores estelares de la Cadena Ser, Luis del Val, nos dan en este libro 50 rostros y 50 perfiles de algunos de los personajes m??s famosos de nuestro pa?≠s. Desde Elsa Pataky hasta Leonor Watling, Jos?(C) Luis Rodr?≠guez Zapatero, Mariano Rajoy, Gervasio Deferr, Fernando Trueba, ?Ålex de la Iglesia, Alberto Ruiz-Gallard?≥n, Alejandro Amen??bar, Antonio L?≥pez, Bel?(C)n Rueda, Concha Velasco, Eduardo Noriega, Ferran Adri?†, Florentino P?(C)rez, Jos?(C) Luis L?≥pez V??zquez, Juan Jos?(C) Mill??s, Nuria Roca, Patricia Conde o Trinidad Jim?(C)nez, Luis del Val comenta con su fina iron?≠a e impecable estilo los retratos de personas que marcan el hoy por hoy de Espa??a.', '/Imagenes/50MiradasDeEspana.jpg', 456),
(8, 16, 2, 'Mujeres en la historia', '25.54', 'Las protagonistas de esta antolog?≠a son mujeres que han cambiado el mundo desde la Segunda Guerra Mundial hasta nuestros d?≠as, en ??mbitos como el arte, la pol?≠tica, la econom?≠a, la cultura y el profesional. A trav?(C)s de los textos de escritoras contempor??neas comprobamos que durante este per?≠odo la mujer no s?≥lo obtiene el derecho al voto, sino, sobre todo, un lugar en la sociedad.', '/Imagenes/MujeresEnLaHistoria.jpg', 45),
(9, 15, 1, 'Jardiel', '18.45', 'Jardiel. La risa inteligente es el m??s completo y valioso estudio de la vida y la obra de Enrique Jardiel Poncela escrito hasta la fecha. Valioso porque su autor, Enrique Gallud Jardiel, a??na varias condiciones indispensables: es un excelente y prol?≠fico escritor, digno sucesor de su abuelo en la literatura, y un investigad or infatigable y riguroso, tanto en las ra?≠ces del humor y del teatro como en otros ??mbitos.', '/Imagenes/Jardiel.jpg', 65),
(10, 14, 2, 'De buen humor', '15.50', 'Orquestas can?≠bales, ratas de hotel, trepadores de fachadas, mujeres extraordinarias y actores extras, fantasmas residentes, almas de tama??o descomunal, magos de la caracterizaci?≥n y otros incre?≠bles y singulares personajes son los protagonistas de estos notables relatos escritos por Jos?(C) Santugini en las primeras d?(C)cadas del siglo xx y publicados en revistas de entonces, como Buen Humor, Blanco y Negro o Cinegramas.', '/Imagenes/DeBuenHumor.jpg', 32),
(11, 13, 3, 'Mossad', '15.10', 'Un peque??o grupo de hombres y mujeres entrenados y silenciosos pasean por la calle o conducen un coche por cualquier ciudad del mundo. Minutos despu?(C)s una persona es asesinada o desaparece sin dejar rastro. Horas despu?(C)s, ellos hacen lo mismo.\r\n\r\nSon los kidones, los elegidos. Miembros del servicio secreto israel?≠ que eliminan a los enemigos de su pa?≠s. Practican el proverbio ¬<<ojo por ojo, diente por diente¬>>, vengan los agravios cometidos en nombre de su pueblo, espiando, matando, secuestrando y puestos en marcha por el primer ministro israel?≠. La sentencia del profeta Ezequiel est?? cumplida:\r\n"Y los enemigos sabr??n que soy el Se??or cuando haga caer mi venganza sobre ellos".\r\n\r\nEste libro identifica por primera vez a todos los agentes del Kidon que, en nombre de Israel y con autorizaci?≥n expresa del primer ministro, ejecutaron entre 1960 y 2010 a criminales de guerra nazis, terroristas, palestinos, alemanes, cient?≠ficos dedicados a la energ?≠a at?≥mica en Irak, l?≠deres de la OLP, Hamas o Hizbollah, ingenieros expertos en armamento, traficantes de armas e, incluso, un magnate de la prensa. Los kidones del Mossad liquidaron, haciendo uso de cualquier medio, a aquellos que supusieron un peligro real o potencial para el Estado de Israel.', '/Imagenes/Mossad.jpg', 39),
(12, 12, 4, 'Muerte a la carta', '18.45', '¬<<Muerte a la carta¬>>, escrito por Eric Frattini y el chef Andr?(C)s Madrigal, es un libro ¬<<morbogastron?≥mico¬>>, en palabras del primero. Una definici?≥n que le viene como anillo al dedo a esta obra que recopila las ??ltimas cenas de cincuenta famosos, de Jesucristo a Juan Pablo I, de Marilyn Monroe a James Gandolfini, de Alejandro Magno a Sadam Husein, de la tragedia del Titanic a los atentados contra las Torres Gemelas', '/Imagenes/MuerteCarta.jpg', 65),
(13, 11, 5, 'Las estrellas de la gastronomia espaÒola', '15.15', 'Es un privilegio disponer de frutas y hortalizas frescas y variadas durante todo el a??o; Un clima ideal para producir aceite de oliva, reconocido como la mejor y m??s natural de las grasas; estar rodeados por tres mares distintos, por costas variadas, suaves y playeras, en unos casos, y escarpadas y batidas en otros; tener un ecosistema casi ??nico en el mundo y adem??s irreproducible, que es la dehesa; disponer de profundos valles junto a elevadas monta??as, buenos pastos; cultivar grandes extensiones de vi??edo, que caracterizan el paisaje y cumplen la principal condici?≥n que puso Leonardo da Vinci a un territorio, ser tierra en la que se produce el vino, para que mereciese la pena vivir en ?(C)', '/Imagenes/LasEtrellasGastronomiaEspanola.jpg', 86),
(14, 10, 6, 'La tradicion en platon', '18.45', 'Afirma en el pr?≥logo el eminente Luc Brisson: "Pedro Amor?≥s propone en La tradici?≥n en Plat?≥n una aproximaci?≥n original a Plat?≥n, no tanto literaria o filos?≥fica como antropol?≥gica, en la l?≠nea desarrollada por la Escuela de Par?≠s representada por Jean-Pierre Vernant, Pierre Vidal-Naquet y Marcel Detienne, y a la cual yo mismo he pertenecido. (‚EUR?) Pero ¬?qu?(C) es la tradici?≥n? Se puede decir que es un conjunto colectivo de saberes y de valores transmitidos en una comunidad determinada de generaci?≥n en generaci?≥n. Estos saberes y estos valores, an?≥nimos por definici?≥n, no son objeto de exposiciones ni de tratados; son ilustrados, o m??s bien puestos en com??n, a trav?(C)s de relatos comunicados de un individuo a otro o a un grupo. (‚EUR?) El uso de la escritura explica en la Grecia antigua la aparici?≥n de dos g?(C)neros literarios: la historia y la filosof?≠a. Plat?≥n vivi?≥ en un mundo donde la escritura se hab?≠a impuesto definitivamente: se ponen, entonces, por escrito las leyes, las obras teatrales, la historia, los discursos en la Asamblea y el Tribunal. Y es en este contexto cultural, despu?(C)s de S?≥crates -que no hab?≠a escrito nada-, cuando Plat?≥n quiere imponer un nuevo g?(C)nero literario, la filosof?≠a, que ?(C)l define por oposici?≥n a la tradici?≥n que estudia y critica".', '/Imagenes/LatradicionEnPlaton.jpg', 46),
(15, 9, 7, 'La cocinera', '25.00', 'Barcelona, 1771. La joven Constan?ßa Clav?(C), de diecis?(C)is a??os, deja la lejana ciudad de Lima tras la muer- te de su padre, un diplom??tico al servicio del virrey Manuel de Amat, para iniciar un largo periplo hasta Barcelona y reunirse con sus abuelos.\r\n\r\nLleva paisajes, gustos y texturas grabados en la memoria, y viaja con su ??nica herencia: el cuaderno de recetas de quien fue su primer maestro en la corte peruana, el chef Antoine Champel. En Barcelona, Constan?ßa sue??a con convertirse en una gran cocinera, aunque su condici?≥n de mujer le cerrar?? muchas puertas.', '/Imagenes/Laocinera.jpg', 61),
(16, 8, 8, 'Grandez pelmazos de las letras universales', '15.45', 'Grandes pelmazos de las letras universales¬>> es una obra valiente que se atreve a reconocer que a muchos de los insignes autores que pueblan las antolog?≠as no hay nadie que les aguante. En ella su insensato autor pone repetidamente la zancadilla a esos gigantes con pies de barro de cuyo prestigio literario nadie duda y que han hecho dormir a varias generaciones de lectores incautos. En estas c?≥micas p??ginas hay muchos escritos ap?≥crifos de escritores que est??n justamente olvidados, un buen n??mero de refritos bien hechos que son un divertid?≠simo resumen de ladrillos infumables y tambi?(C)n un pu??ado de art?≠culos desmitificadores que demuestran sin lugar a dudas que la literatura es algo nefasto y deleznable. El autor no se arredra ante nadie y arremete contra escritores consagrados. Shakespeare, San Juan de la Cruz, Wilde, Lope, Quevedo, Arniches, Calder?≥n, Salinger, Eur?≠pides, G?≥ngora, Conan Doyle, Morat?≠n y muchos otros quedan aqu?≠ puestos a caer de un burro. Y muchos conceptos literarios ‚EUR"los cl??sicos, las antolog?≠as, las ediciones abreviadas, las figuras ret?≥ricas, la versificaci?≥n, etc.‚EUR" son vapuleados sin compasi?≥n para diversi?≥n y regocijo de los lectores', '/Imagenes/GrandesPelmazosDeLasLetrasUniversales.jpg', 25),
(17, 7, 9, 'De buen humor', '28.00', 'Orquestas can?≠bales, ratas de hotel, trepadores de fachadas, mujeres extraordinarias y actores extras, fantasmas residentes, almas de tama??o descomunal, magos de la caracterizaci?≥n y otros incre?≠bles y singulares personajes son los protagonistas de estos notables relatos escritos por Jos?(C) Santugini en las primeras d?(C)cadas del siglo xx y publicados en revistas de entonces, como Buen Humor, Blanco y Negro o Cinegramas.', '/Imagenes/DeBuenHumor.jpg', 47),
(18, 6, 8, 'La isla del padre', '45.00', 'Un homenaje al padre. Un viaje a la infancia. Una novela luminosa. Cuando era peque??o, su padre recorr?≠a los mares del mundo durante largos meses. Un d?≠a apareci?≥ en la puerta de la casa de Bilbao. El ni??o no lo conoc?≠a. ¬<<¬?Qui?(C)n es ese hombre?¬>>, pregunt?≥. A mitad de camino entre la memoria y la fantas?≠a, este libro surge a la muerte de Leonardo Mar?≠as, cuando su hijo Fernando se deja llevar por la escritura como alternativa al duelo y se adentra sin miedo en cada rinc?≥n de s?≠ mismo y de su relaci?≥n con el inalcanzable personaje que es el padre marino a los ojos del ni??o, del adolescente, del joven que fue y del hombre que es hoy. Padre e hijo embarcan rumbo al paisaje de la infancia y sus carencias, a la temprana fascinaci?≥n por la literatura y el cine; un itinerario poblado por piratas y maleantes, por miedos y leyendas, por la presencia de un h?(C)roe misterioso que se convierte en referencia vital. En la libertad con que va desgranando ese viaje, Fernando Mar?≠as encuentra el punto de equilibrio entre la nostalgia y la realizaci?≥n, entre el miedo y la certidumbre. ', '/Imagenes/LaIslaDelPadre.jpg', 59),
(19, 5, 7, 'Yo Dante Alighieri', '45.54', 'Los hechos, cuando suceden, son circunstanciales, pero se convierten en atemporales y hasta conmovedores cuando los registra como en un sue??o el alma sensible de un poeta. Lo que encontrar?? el lector en este libro es portentoso bajo todo punto de vista. En su destierro de Florencia ‚EUR"que dur?≥ casi dos d?(C)cadas, hasta su muerte‚EUR", Dante Alighieri no solo escribi?≥ su perdurable Comedia (adjetivada como divina por Giovanni Boccaccio), esa obra maestra que lo inmortalizar?≠a en la literatura universal, sino tambi?(C)n un texto secreto que relata sucesos esenciales de su vida y las peripecias que debi?≥ atravesar durante los a??os condenado a permanecer fuera de su patria.', '/Imagenes/LaFragilidadDelNeon.jpg', 63),
(20, 4, 6, 'La mejor defensa es un buen ataque de risa', '28.00', 'En este libro constatamos que en tiempos en que las ideolog?≠as y la ?(C)tica han sido arrasadas por la globalizaci?≥n liberal capitalista dura y la supuesta izquierda ha perdido el norte y en lugar de pol?≠tica hace brindis al sol, hay qu?(C) plantearse hacia d?≥nde nos lleva la postmodernidad. Parece que ha acabado la historia, pero hay que comenzar otra historia.\r\n', '/Imagenes/LaMejorDefensaEsUnBuenAtaqueRisaisa.jpg', 26),
(21, 3, 5, 'Los niÒos de los chiripitiflauticos', '15.88', 'M??s de siete millones de beb?(C)s nacieron en Espa??a en los sesenta, la d?(C)cada con mayor ?≠ndice de natalidad del siglo XX. \r\n\r\nDe ni??os ve?≠an "Un globo, dos globos, tres globos", devoraban los libros de Enid Blyton y ten?≠an rotuladores Carioca, l??pices Alpino y gomas de "nata". Espectadores privilegiados de la Transici?≥n, fueron creciendo al mismo tiempo que la sociedad espa??ola. ', '/Imagenes/LosNinosChiripitiflauticos.jpg', 86),
(22, 2, 4, 'El mapa de la india', '15.45', 'El mapa de la India. Conversaciones con Manolo Matji es una entrevista en profundidad con uno de los profesionales m??s activos del cine y la televisi?≥n de la Transici?≥n y las primeras d?(C)cadas de la Democracia. Manolo Matji empieza a trabajar como guionista para TVE en los a??os setenta, sobre todo, en programas culturales. En la d?(C)cada siguiente compagina su trabajo como guionista de televisi?≥n con una intensa dedicaci?≥n a la escritura para el cine, de la que nacer??n pel?≠culas como El hombre de moda, Los santos inocentes o El sue??o del mono loco y con sus primeras intervenciones como productor en ?"pera prima y La mano negra. ', '/Imagenes/ElMapaDeLaIndia.jpg', 45),
(23, 1, 3, 'La fragilidad del neon', '987.20', 'A menudo olvidamos la fragilidad de nuestras democracias. Y es que el exceso de opiniones y de puntos de vista no significa necesariamente que sostengamos un sistema pol?≠tico abierto. A veces, todo pende de un hilo y apenas podemos imaginarlo.\r\n\r\nRam?≥n Sandoval, un inmigrante espa??ol refugiado en Par?≠s, trabaja como ch?≥fer tras perder su particular guerra en Espa??a. Pero la capital francesa en 1961 no es un para?≠so. El conflicto argelino aviva los peores resentimientos en algunas facciones del ej?(C)rcito que amenazan con derrocar la democracia bajo el pretexto del colonialismo.', '/Imagenes/LaFragilidadDelNeon.jpg', 98),
(24, 2, 2, 'Ejecucion Submarina', '27.54', 'En la madrugada del 3 de marzo de 1974 el militante del Movimiento Ib?(C)rico de Liberaci?≥n Salvador Puig Antich fue ajusticiado a garrote vil en la Prisi?≥n Modelo de Barcelona. El silencio y la indiferencia fueron dominantes en la sociedad barcelonesa ante la detenci?≥n del muchacho de veintis?(C)is a??os, su posterior e inmediato Consejo de Guerra y finalmente la condena, para la que nunca lleg?≥ el indulto, en contraposici?≥n a las movilizaciones que se vivieron por el Consejo de Guerra de Burgos contra los militantes de ETA en diciembre de 1970 que s?≠ acabar?≠an con indultos. ', '/Imagenes/EjecucionSubmarina.jpg', 89),
(25, 3, 1, 'Operacion Gladio', '15.46', '¬?Qu?(C) ten?≠an en com??n el asesinato de los abogados laboralistas de la calle de Atocha, el magnicidio del almirante Carrero Blanco, los atentados de los GRAPO, la guerra sucia contra ETA y la violencia que jalon?≥ la Transici?≥n espa??ola?', '/Imagenes/OperacionGladio.jpg', 39),
(26, 23, 9, 'conexo', '100.00', 'Cinco chicos. Un viaje cambiar?? sus vidas. ¬?Lograr??n dominar su destino?\r\nEl tren que lleva a los estudiantes de Conexo a esquiar descarrila al atravesar un t??nel en las monta??as. Eva, Noel, Sabina, Gabi, Ana y Sam son los ??nicos supervivientes. Pero nadie acude a rescatarlos. Y es que en Conexo hay seis chicos id?(C)nticos a ellos ocupando su lugar? ¬?Por qu?(C) est??n duplicados? ¬?Qu?(C) ocurri?≥ realmente en el t??nel de la monta??a? El grupo tendr?? que resolver el rompecabezas antes de que el mundo colapse por su culpa', '/Imagenes/Conexo.jpg', 39);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombres_usuario` varchar(80) NOT NULL,
  `apellidos_usuario` varchar(80) NOT NULL,
  `fechanacimiento_usuario` date NOT NULL,
  `email_usuario` varchar(50) NOT NULL,
  `username_usuario` varchar(20) NOT NULL,
  `password_usuario` varchar(20) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombres_usuario`, `apellidos_usuario`, `fechanacimiento_usuario`, `email_usuario`, `username_usuario`, `password_usuario`) VALUES
(1, 'jorge', 'martinez', '2014-10-10', 'jorge@gmail.com', 'jorge', 'jorge'),
(2, 'a', 'a', '2015-07-16', 'a@f.com', 'a', 'a'),
(3, 'n', 'n', '2015-07-25', 't@g.min', 'n', 'n'),
(4, 'b', 'b', '2015-07-23', 'b@g.com', 'b', 'b'),
(5, 'marco', 'marco', '2015-07-31', 'g@r.com', 'marco', 'marco');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `fk_relationship_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `fk_relationship_2` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id_autor`);
