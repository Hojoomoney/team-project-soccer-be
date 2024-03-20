package com.rod.api.crawler;

import java.io.IOException;
import java.util.Map;

public interface CrawlerService {
    Map<String, ?> findNamesFromWeb(Map<String, String> paramMap) throws IOException;

    Map<String,?> findNamesFromWebMelon(Map<String, String> paramMap) throws IOException;
}
