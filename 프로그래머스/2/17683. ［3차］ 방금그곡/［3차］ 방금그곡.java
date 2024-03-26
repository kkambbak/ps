import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        m=m.replaceAll("C#", "H");
        m=m.replaceAll("D#", "I");
        m=m.replaceAll("F#", "J");
        m=m.replaceAll("G#", "K");
        m=m.replaceAll("A#", "L");
        m=m.replaceAll("E#", "M");
        m=m.replaceAll("B#", "N");
        
        Music[] musics = new Music[musicinfos.length];
        
        for(int i = 0; i < musicinfos.length; i++){
            String[] music = musicinfos[i].split(",");
            String melody = music[3];
            
            music[3]=music[3].replaceAll("C#", "H");
            music[3]=music[3].replaceAll("D#", "I");
            music[3]=music[3].replaceAll("F#", "J");
            music[3]=music[3].replaceAll("G#", "K");
            music[3]=music[3].replaceAll("A#", "L");
            music[3]=music[3].replaceAll("E#", "M");
            music[3]=music[3].replaceAll("B#", "N");
            
            int l = stoi(music[1]) - stoi(music[0]);            
            if(music[3].length() < l){
                StringBuilder sb = new StringBuilder();
                int r = l % music[3].length();
                int n = l / music[3].length();
                for(int j = 0; j < n; j++){
                    sb.append(music[3]);
                }
                sb.append(music[3].substring(0,r));
                melody = sb.toString();
                //System.out.println(melody);
            } else{
                melody = music[3].substring(0,l);
            }
            musics[i] = new Music(music[0], music[1], music[2], melody, l);
        }
        
        Music selected = null;
        for(Music music: musics){
            if(music.melody.contains(m)){
                
                if(selected == null){
                    selected = music;
                }
                else{
                    if(selected.l < music.l){
                        selected = music;
                        //System.out.println(selected.name);
                    }
                }
            }
        }
        
        return selected==null? "(None)" : selected.name;
    }
    
    public int stoi(String s){
        return 60*(10 * s.charAt(0) + s.charAt(1)) + 10 * s.charAt(3) + s.charAt(4);
    }
}

class Music{
    String start;
    String end;
    String name;
    String melody;
    int l;
    
    public Music(String start, String end, String name, String melody, int l){
        this.start= start;
        this.end = end;
        this.name = name;
        this.melody = melody;
        this.l = l;
    }
}