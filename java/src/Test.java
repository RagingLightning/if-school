import de.r13g.lib.ArrayTools;
import de.r13g.lib.Search;
import de.r13g.lib.Tools;
import de.r13g.lib.console.ConsoleExt;

import java.util.Arrays;

public class Test {

  public static void main(String[] args)
  {
    while (true) {
      int[] array = {2, 4, 5, 8, 8, 14, 14, 17, 17, 17, 19, 22, 22, 30, 39, 43, 45, 45, 54, 54, 55, 56, 59, 59, 60, 64, 64, 65, 66, 69, 70, 71, 72, 73, 73, 75, 78, 81, 83, 86, 90, 96, 96, 99, 102, 103, 104, 104, 106, 108, 109, 112, 116, 129, 130, 133, 133, 135, 137, 139, 140, 140, 141, 142, 143, 144, 144, 144, 145, 145, 146, 148, 150, 151, 151, 153, 155, 158, 162, 163, 163, 163, 164, 166, 167, 167, 173, 173, 178, 180, 182, 183, 185, 185, 187, 189, 192, 194, 198, 199, 199, 200, 200, 206, 207, 208, 209, 210, 213, 216, 220, 220, 222, 223, 224, 225, 227, 229, 237, 240, 240, 240, 241, 242, 243, 244, 244, 250, 252, 253, 254, 257, 259, 261, 262, 268, 274, 274, 279, 280, 284, 286, 286, 290, 296, 303, 306, 308, 308, 311, 312, 313, 315, 315, 315, 316, 317, 319, 320, 322, 325, 326, 327, 330, 332, 333, 333, 334, 334, 335, 336, 337, 342, 343, 346, 349, 353, 353, 353, 357, 362, 364, 364, 367, 369, 371, 372, 374, 375, 377, 378, 379, 383, 388, 389, 390, 393, 393, 397, 398, 401, 403, 404, 405, 406, 406, 408, 408, 408, 411, 412, 412, 413, 416, 416, 422, 423, 429, 432, 432, 432, 433, 440, 440, 442, 442, 444, 445, 456, 458, 460, 464, 466, 470, 475, 476, 481, 487, 490, 491, 492, 494, 499, 501, 501, 502, 503, 503, 504, 504, 506, 508, 511, 513, 515, 516, 516, 519, 523, 526, 527, 527, 528, 530, 531, 534, 534, 535, 540, 540, 543, 543, 545, 552, 553, 554, 555, 559, 561, 562, 562, 567, 568, 568, 572, 573, 573, 574, 576, 577, 581, 581, 584, 585, 588, 588, 590, 590, 591, 591, 593, 594, 598, 598, 604, 606, 608, 609, 610, 610, 611, 612, 612, 612, 614, 617, 618, 619, 621, 622, 622, 624, 632, 633, 634, 636, 636, 639, 639, 640, 640, 643, 646, 649, 654, 658, 659, 660, 662, 662, 665, 667, 668, 670, 670, 672, 674, 674, 675, 676, 677, 677, 679, 681, 681, 683, 690, 693, 693, 695, 697, 699, 701, 701, 702, 704, 705, 707, 714, 715, 715, 719, 724, 725, 725, 726, 726, 727, 730, 730, 732, 733, 736, 738, 739, 739, 742, 746, 747, 747, 748, 751, 751, 751, 751, 761, 762, 762, 764, 765, 765, 767, 769, 769, 772, 773, 777, 778, 780, 784, 792, 793, 796, 796, 797, 798, 805, 806, 810, 818, 819, 819, 823, 826, 829, 832, 834, 834, 837, 837, 837, 837, 838, 840, 840, 843, 843, 845, 848, 848, 850, 860, 861, 862, 866, 868, 874, 876, 876, 876, 876, 877, 878, 880, 882, 882, 883, 889, 890, 892, 897, 898, 901, 903, 903, 904, 905, 908, 909, 909, 909, 910, 912, 914, 915, 921, 922, 923, 923, 925, 933, 938, 938, 941, 948, 949, 951, 954, 955, 960, 960, 961, 964, 968, 968, 968, 969, 970, 974, 974, 974, 975, 975, 978, 986, 989, 989, 990, 990, 990, 992, 996, 997, 1000, 1000, 1002, 1005, 1009, 1009, 1010, 1011, 1011, 1011, 1013, 1014, 1015, 1018, 1020, 1023, 1024, 1025, 1025, 1027, 1028, 1030, 1032, 1038, 1041, 1041, 1042, 1043, 1046, 1049, 1051, 1051, 1051, 1053, 1053, 1054, 1060, 1061, 1063, 1064, 1065, 1068, 1070, 1070, 1076, 1077, 1079, 1081, 1083, 1089, 1092, 1093, 1094, 1096, 1096, 1096, 1097, 1097, 1099, 1100, 1106, 1108, 1108, 1109, 1109, 1111, 1111, 1112, 1114, 1115, 1116, 1116, 1118, 1119, 1121, 1122, 1123, 1125, 1128, 1129, 1130, 1130, 1132, 1135, 1138, 1141, 1144, 1145, 1147, 1148, 1149, 1151, 1152, 1152, 1157, 1159, 1159, 1159, 1167, 1171, 1172, 1173, 1175, 1175, 1176, 1177, 1178, 1179, 1184, 1193, 1193, 1194, 1199, 1204, 1205, 1208, 1209, 1209, 1213, 1216, 1218, 1220, 1221, 1226, 1226, 1226, 1228, 1229, 1230, 1231, 1232, 1233, 1234, 1235, 1236, 1238, 1238, 1240, 1242, 1242, 1242, 1244, 1244, 1248, 1250, 1251, 1257, 1258, 1261, 1265, 1267, 1267, 1272, 1275, 1275, 1276, 1279, 1280, 1281, 1283, 1285, 1285, 1287, 1290, 1295, 1301, 1310, 1310, 1312, 1317, 1320, 1327, 1327, 1329, 1329, 1332, 1333, 1333, 1334, 1336, 1340, 1341, 1341, 1343, 1345, 1352, 1354, 1356, 1358, 1359, 1363, 1365, 1366, 1367, 1367, 1368, 1372, 1375, 1377, 1379, 1383, 1384, 1385, 1387, 1388, 1394, 1395, 1395, 1396, 1399, 1403, 1404, 1411, 1413, 1425, 1427, 1431, 1433, 1439, 1439, 1442, 1444, 1446, 1448, 1450, 1451, 1453, 1454, 1456, 1458, 1458, 1462, 1463, 1463, 1465, 1467, 1470, 1472, 1474, 1476, 1477, 1480, 1480, 1481, 1489, 1490, 1493, 1496, 1497, 1503, 1505, 1506, 1509, 1509, 1510, 1511, 1512, 1517, 1520, 1522, 1522, 1523, 1523, 1524, 1524, 1526, 1527, 1529, 1531, 1533, 1537, 1538, 1543, 1543, 1545, 1557, 1557, 1557, 1558, 1560, 1561, 1562, 1564, 1564, 1566, 1573, 1575, 1580, 1581, 1584, 1590, 1594, 1595, 1597, 1603, 1603, 1604, 1606, 1606, 1610, 1610, 1611, 1614, 1614, 1615, 1615, 1617, 1618, 1619, 1620, 1621, 1623, 1626, 1627, 1629, 1630, 1631, 1635, 1635, 1636, 1637, 1641, 1642, 1648, 1648, 1648, 1649, 1649, 1654, 1655, 1658, 1661, 1661, 1663, 1666, 1666, 1668, 1671, 1672, 1672, 1678, 1678, 1687, 1688, 1689, 1695, 1695, 1697, 1697, 1699, 1701, 1703, 1706, 1707, 1709, 1709, 1710, 1711, 1711, 1714, 1717, 1719, 1719, 1720, 1722, 1723, 1724, 1724, 1724, 1724, 1728, 1729, 1730, 1733, 1733, 1736, 1742, 1743, 1744, 1749, 1750, 1751, 1751, 1754, 1758, 1761, 1763, 1765, 1765, 1765, 1766, 1767, 1767, 1767, 1769, 1771, 1773, 1773, 1775, 1776, 1781, 1782, 1783, 1783, 1784, 1786, 1787, 1789, 1789, 1790, 1790, 1791, 1792, 1794, 1797, 1804, 1806, 1806, 1807, 1809, 1812, 1813, 1814, 1815, 1816, 1817, 1820, 1820, 1822, 1823, 1823, 1826, 1828, 1828, 1829, 1830, 1830, 1832, 1835, 1839, 1842, 1842, 1844, 1848, 1849, 1851, 1852, 1854, 1854, 1855, 1856, 1859, 1859, 1863, 1865, 1865, 1867, 1869, 1869, 1873, 1877, 1878, 1879, 1879, 1882, 1883, 1883, 1886, 1889, 1895, 1900, 1901, 1916, 1917, 1920, 1921, 1924, 1929, 1931, 1931, 1933, 1933, 1934, 1938, 1940, 1940, 1944, 1947, 1948, 1951, 1952, 1953, 1954, 1955, 1955, 1955, 1958, 1961, 1961, 1965, 1968, 1968, 1969, 1971, 1973, 1973, 1975, 1983, 1990, 1991, 1993};
      /*int[] array = new int[1024];
      for (int i = 0; i < array.length; i++) {
        array[i] = Tools.randomInt(1, 2000);
      }
      Arrays.sort(array);*/

      int key = ConsoleExt.getInputInt("Zu suchende Zahl");
      int i = Search.binarySearch(array, key);
      if (i == -1) System.out.printf("Zahl %d ist nicht im array vorhanden%n", key);
      else System.out.printf("Zahl %1$d ist an Stelle %2$d im array vorhanden%n", key, i);
      for (int n : array) System.out.print("" + n + ", ");
    }
  }

}