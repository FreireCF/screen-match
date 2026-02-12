package br.com.alura.sreenmatch.models;

import java.util.LinkedList;
import java.util.List;

public class tvShow extends Title {
    private int seasons;
    private int totalEpisodes;
    private boolean isComing;
    private List<Episode> episodes = new LinkedList<>();

    public tvShow(){}

    public tvShow(String name, int year, boolean isInPlan, int seasons, int episodes, boolean isComing){
        super(name, year, isInPlan);
        this.seasons = seasons;
        this.totalEpisodes = episodes;
        this.isComing = isComing;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setEpsPorTemp(int episodes) {
        this.totalEpisodes = episodes;
    }

    public boolean isComing() {
        return isComing;
    }

    public void setComing(boolean coming) {
        this.isComing = coming;
    }

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    @Override
    public String toString() {
        String result =
                "\nTítulo: "+ getName()
                +" ("+ getYear()+")"
                +"\nTemporadas: "+ seasons
                +"\nTotal de epsódios: "+ totalEpisodes
                +String.format("\nMédia de avaliações: %.2f", calculateReview())
                +"\nSituação: ";

        result += isComing ? "em lançamento" : "finalizada";

        if(!episodes.isEmpty() && episodes !=null){
            result += "\nLista de epsódios: ";
            for (Episode e: episodes){
                if(e.getSerie().getName().equals(this.getName())){
                    result += "\n- Temp: " + e.getSeason()
                            + " Ep: " + e.getNumber()
                            + " - \"" + e.getName()
                            +"\"";
                }
            }
        }
        return result;
    }
}
