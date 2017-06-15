package ro.dutylabs.mpp.web.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Created by cosmin on 14/06/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class FilterDto implements Serializable {
    private String filterType;
    private String filterValue;
}
