package za.co.nico.poc.dtos.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Facet {

	List<Object> object;
}
