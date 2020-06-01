package com.banshee.infoclients.utility;

import com.banshee.infoclients.configuration.Constants;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

public class PageableUtility {

    private PageableUtility() {
        throw new IllegalStateException("Utility class");
    }

    public static PageRequest newPage(Map<String, String> map) {
        PageRequest pageRequest;
        if (StringUtils.isNumeric(map.get(Constants.NUMERO_PAGINA))
            && StringUtils.isNumeric(map.get(Constants.ELEMENTOS_POR_PAGINA))) {
            pageRequest = PageRequest.of(Integer.parseInt(map.get(Constants.NUMERO_PAGINA)),
                Integer.parseInt(map.get(Constants.ELEMENTOS_POR_PAGINA)));
        } else {
            pageRequest = PageRequest.of(0, Integer.MAX_VALUE);
        }
        return pageRequest;
    }
}
