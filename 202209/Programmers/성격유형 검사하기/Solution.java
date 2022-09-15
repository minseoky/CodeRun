class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int scoreR = 0;
        int scoreT = 0;
        int scoreF = 0;
        int scoreC = 0;
        int scoreM = 0;
        int scoreJ = 0;
        int scoreA = 0;
        int scoreN = 0;
        for (int i = 0 ; i < survey.length ; i++){
            String input = survey[i];
            switch (input){
                case "RT" :
                    scoreT += choices[i]-4;
                    break;
                case "TR" :
                    scoreR += choices[i]-4;
                    break;
                case "FC" :
                    scoreC += choices[i]-4;
                    break;
                case "CF" :
                    scoreF += choices[i]-4;
                    break;
                case "MJ" :
                    scoreJ += choices[i]-4;
                    break;
                case "JM" :
                    scoreM += choices[i]-4;
                    break;
                case "AN" :
                    scoreN += choices[i]-4;
                    break;
                case "NA" :
                    scoreA += choices[i]-4;
                    break;
            }
        }
        System.out.println("R :" + scoreR);
        System.out.println("T :" + scoreT);
        System.out.println("F :" + scoreF);
        System.out.println("C :" + scoreC);
        System.out.println("M :" + scoreM);
        System.out.println("J :" + scoreJ);
        System.out.println("A :" + scoreA);
        System.out.println("N :" + scoreN);
        if (scoreR >= scoreT){
            answer = answer.concat("R");
        }
        else {
            answer = answer.concat("T");
        }
        if (scoreC >= scoreF){
            answer = answer.concat("C");
        }
        else {
            answer = answer.concat("F");
        }
        if (scoreJ >= scoreM){
            answer = answer.concat("J");
        }
        else {
            answer = answer.concat("M");
        }
        if (scoreA >= scoreN){
            answer = answer.concat("A");
        }
        else {
            answer = answer.concat("N");
        }
        return answer;
    }
}