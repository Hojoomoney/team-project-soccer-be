package com.rod.api.crawler;

import com.rod.api.common.AbstractRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CrawlerRepository extends AbstractRepository {
    private static CrawlerRepository instance = new CrawlerRepository();
    private Map<String, ?> map;
    private CrawlerRepository(){
        map = new HashMap();
    }
    public static CrawlerRepository getInstance(){
        return instance;
    }

    @Override
    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        Document doc = Jsoup.connect("https://music.bugs.co.kr/chart").timeout(10 * 1000).get();
        Elements elems = doc.select("table.byChart");
        Iterator<Element> title = elems.select("p.title").iterator();
        Iterator<Element> artist = elems.select("p.artist").iterator();
        Iterator<Element> rank = elems.select("strong").iterator();
        Map<String, Iterator<Element>> localMap = new HashMap<>();
        localMap.put("title", title);
        localMap.put("artist", artist);
        localMap.put("rank", rank);
        map = localMap;
        return map;
    }

    public Map<String,?> saveMelon(Map<String, String> paramMap) throws IOException {
        Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").timeout(10 * 1000).get();
        Elements elems = doc.select("tbody");
        Iterator<Element> title = elems.select("div.ellipsis.rank01 > span").iterator();
        Iterator<Element> artist = elems.select("div.ellipsis.rank02 > span").iterator();
        Iterator<Element> rank = elems.select("span.rank").iterator();
        Map<String, Iterator<Element>> localMap = new HashMap<>();
        localMap.put("title", title);
        localMap.put("artist", artist);
        localMap.put("rank", rank);
        map = localMap;
        return map;
    }
}
