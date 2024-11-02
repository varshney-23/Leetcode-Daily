class Solution {
    public boolean isCircularSentence(String sent) {
        if (!sent.contains(" ")) {
            return sent.charAt(0) == sent.charAt(sent.length() - 1);
        }
        for(int i = 0 ; i < sent.length() ; i++){
            if(sent.charAt(i) == ' '){
                char prev = sent.charAt(i - 1);
                char next = sent.charAt(i + 1);
                if(prev != next){
                    return false;
                }
            }
        }
        return sent.charAt(0) == sent.charAt(sent.length() - 1);
    }
}