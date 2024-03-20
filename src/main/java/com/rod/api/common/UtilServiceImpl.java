package com.rod.api.common;

public class UtilServiceImpl implements UtilService {

    private static UtilService instance = new UtilServiceImpl();
    private UtilServiceImpl(){}
    public static UtilService getInstance(){
        return instance;
    }
    @Override
    public int createRandomInteger(int start, int end) {
        return (int) (Math.random()*(end-start))+start;
    }

    @Override
    public double createRandomDouble(int start, int end) {
        return Double.parseDouble(
                String.format("%.1f",
                        (Math.random()*(end-start))+start));
    }

    @Override
    public String createRandomName() {
        String[] names = {"이정재", "마동석", "송강호", "윤여정", "황정민",
                "정우성", "이병헌", "현 빈", "유해진", "손석구",
                "전도연", "손예진", "하지원", "김하늘", "송중기",
                "하정우", "장동건", "원 빈", "박해일", "소지섭", "김혜"};
        return names[createRandomInteger(0,20)];
    }

    @Override
    public String createRandomTitle() {
        String[] titles = {"주거의 자유","체포 또는 구속","국회의원이 회기전","국가안전보장회의", "국가안전보장",
                "농·어민과 중소기업","헌법개정안","국토와 자원","행정심판","헌법재판소 재판관"};
        return titles[createRandomInteger(0,9)];
    }

    @Override
    public String createRandomContent() {
        String[] contents = {
                "모든 국민은 주거의 자유를 침해받지 아니한다. 주거에 대한 압수나 수색을 할 때에는 검사의 신청에 의하여 법관이 발부한 영장을 제시하여야 한다.",
                "누구든지 체포 또는 구속을 당한 때에는 즉시 변호인의 조력을 받을 권리를 가진다.",
                "국회의원이 회기전에 체포 또는 구금된 때에는 현행범인이 아닌 한 국회의 요구가 있으면 회기중 석방된다.",
                "국가안전보장회의는 대통령이 주재한다. 대한민국의 국민이 되는 요건은 법률로 정한다.",
                "누구든지 체포 또는 구속의 이유와 변호인의 조력을 받을 권리가 있음을 고지받지 아니하고는 체포 또는 구속을 당하지 아니한다.",
                "체포 또는 구속을 당한 자의 가족등 법률이 정하는 자에게는 그 이유와 일시·장소가 지체없이 통지되어야 한다.",
                "국가안전보장에 관련되는 대외정책·군사정책과 국내정책의 수립에 관하여 국무회의의 심의에 앞서 대통령의 자문에 응하기 위하여 국가안전보장회의를 둔다.",
                "국가는 농·어민과 중소기업의 자조조직을 육성하여야 하며, 그 자율적 활동과 발전을 보장한다",
                "제안된 헌법개정안은 대통령이 20일 이상의 기간 이를 공고하여야 한다.",
                "모든 국민은 신체의 자유를 가진다.",
                "누구든지 법률에 의하지 아니하고는 체포·구속·압수·수색 또는 심문을 받지 아니하며, 법률과 적법한 절차에 의하지 아니하고는 처벌·보안처분 또는 강제노역을 받지 아니한다.",
                "국토와 자원은 국가의 보호를 받으며, 국가는 그 균형있는 개발과 이용을 위하여 필요한 계획을 수립한다.",
                "재판의 전심절차로서 행정심판을 할 수 있다. 행정심판의 절차는 법률로 정하되, 사법절차가 준용되어야 한다.",
                "이 헌법은 1988년 2월 25일부터 시행한다. 다만, 이 헌법을 시행하기 위하여 필요한 법률의 제정·개정과 이 헌법에 의한 대통령 및 국회의원의 선거 기타 이 헌법시행에 관한 준비는 이 헌법시행 전에 할 수 있다.",
                "헌법재판소 재판관은 탄핵 또는 금고 이상의 형의 선고에 의하지 아니하고는 파면되지 아니한다.",
                "대통령은 헌법과 법률이 정하는 바에 의하여 국군을 통수한다.",
                "국가는 사회보장·사회복지의 증진에 노력할 의무를 진다. 제1항의 해임건의는 국회재적의원 3분의 1 이상의 발의에 의하여 국회재적의원 과반수의 찬성이 있어야 한다.",
                "중앙선거관리위원회는 법령의 범위안에서 선거관리·국민투표관리 또는 정당사무에 관한 규칙을 제정할 수 있으며, 법률에 저촉되지 아니하는 범위안에서 내부규율에 관한 규칙을 제정할 수 있다.",
                "대법원장의 임기는 6년으로 하며, 중임할 수 없다. 국가는 과학기술의 혁신과 정보 및 인력의 개발을 통하여 국민경제의 발전에 노력하여야 한다."
        };
        return contents[createRandomInteger(0,18)];


    }

    @Override
    public String createRandomCompany() {
        String[] companies = {"구글","엔비디아","메타","삼성","LG","애플"};
        return companies[createRandomInteger(0,5)];
    }

    @Override
    public String createRandomUsername() {
        String username = "";

        for(;
            username.length() < 5;
            username += String.valueOf((char)('a' + this.createRandomInteger(0, 26))));
        return username;
    }

    @Override
    public String createRandomJob() {
        String job[] = {"교사","운동선수","배우","가수","엔지니어",
                        "기사","기자","의사","변호사","판사",
                        "농부","소방관","경찰관","간호사"};
        return job[createRandomInteger(0,13)];
    }

}
