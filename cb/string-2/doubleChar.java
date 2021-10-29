public String doubleChar(String str){
 String newStr = "";
 for (int i = 0; i < str.length(); i++){
  newStr + (str.substring(i,i+1)) + (str.substring(i,i+1));
 }
 return newStr;
}
