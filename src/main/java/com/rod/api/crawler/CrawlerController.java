package com.rod.api.crawler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CrawlerController {
    private CrawlerServiceImpl crawlerService = CrawlerServiceImpl.getInstance();

    public Map<String,?> findBugsMusic(Scanner sc) throws IOException {
        System.out.println("크롤링할 주소를 입력하시오.");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("URL",sc.next());
        return crawlerService.findNamesFromWeb(paramMap);
    }

    public Map<String,?> findMelonMusic(Scanner sc) throws IOException {
        System.out.println("크롤링할 주소를 입력하시오.");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("URL",sc.next());
        return crawlerService.findNamesFromWebMelon(paramMap);
    }
}
