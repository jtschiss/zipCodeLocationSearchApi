package zipCodeLocator.entity.placesInfo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Places{

	@JsonProperty("summary")
	private Summary summary;

	@JsonProperty("results")
	private List<ResultsItem> results;

	public void setSummary(Summary summary){
		this.summary = summary;
	}

	public Summary getSummary(){
		return summary;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"Places{" + 
			"summary = '" + summary + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}