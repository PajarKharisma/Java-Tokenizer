/*
SQLyog Enterprise - MySQL GUI v7.14 
MySQL - 5.6.20 : Database - db_kamus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_kamus` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_kamus`;

/*Table structure for table `kamus_tbl` */

DROP TABLE IF EXISTS `kamus_tbl`;

CREATE TABLE `kamus_tbl` (
  `data` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kamus_tbl` */

insert  into `kamus_tbl`(`data`) values ('akal bulus'),('anak bawang'),('anak buah'),('anak emas'),('angkat bicara'),('angkat kaki'),('angkat tangan'),('angkat topi'),('aral melintang'),('babi buta'),('badan dua'),('banting tulang'),('berat hati'),('berat sebelah'),('besar hati'),('besar kepala'),('besar mulut'),('biang keladi'),('buah bibir'),('buah dada'),('buah pelir'),('buah tangan'),('buaya darat'),('buku biru'),('buku putih'),('buta hati'),('cari muka'),('campur tangan'),('cuci otak'),('cuci tangan'),('daftar hitam'),('darah biru'),('darah daging'),('darah dingin'),('darah putih'),('emas hitam'),('gelap mata'),('gigit jari'),('gulung tikar'),('haus darah'),('hidung belang'),('hukum rimba'),('jaga mulut'),('jago merah'),('jalan pintas'),('ilmu komputer'),('jiwa besar'),('kabar angin'),('kaki tangan'),('kambing hitam'),('kecil hati'),('kelinci percobaan'),('kepala batu'),('kepala dingin'),('kepala dua'),('kepala udang'),('keras kepala'),('kuli tinta'),('kutu buku'),('kutu loncat'),('lapang dada'),('lapangan hijau'),('lebar mulut'),('lepas tangan'),('lintah darat'),('lupa daratan'),('lupa diri'),('macan ompong'),('main mata'),('main tangan'),('mata keranjang'),('meja hijau'),('muka dua'),('muka badak'),('muka dinding'),('muka tebal'),('mulut besar'),('mulut harimau'),('mulut manis'),('murah hati'),('naik darah'),('naik daun'),('naik pitam'),('orang jauh'),('otak udang'),('pangku tangan'),('panjang tangan'),('panjang umur'),('penghisap darah'),('pengacara hitam'),('peti es'),('putih mata'),('rendah hati'),('ringan tangan'),('rumah sakit'),('sakit hati'),('sapi perahan'),('sebatang kara'),('silat lidah'),('sistem informasi'),('sapi perah'),('tahan banting'),('tangan besi'),('tangan kanan'),('tebal hati'),('tinggi hati'),('tukar guling'),('tutup mulut'),('tutup usia'),('turun tangan'),('teknik informatika'),('unjuk gigi'),('racun tikus'),('belahan dada'),('berjiwa besar'),('tangan dingin'),('belahan jiwa'),('buah hati');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
