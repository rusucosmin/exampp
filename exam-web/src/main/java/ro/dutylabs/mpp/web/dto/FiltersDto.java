package ro.dutylabs.mpp.web.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by cosmin on 14/06/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FiltersDto implements Serializable {
    private Set<FilterDto> filters;
}
