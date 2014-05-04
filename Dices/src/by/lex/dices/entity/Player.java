package by.lex.dices.entity;

/**
 * @author admin
 * 
 * Should be removed
 */

@Deprecated
/**
 * 
 * @author admin
 * Use PlayerTable instead
 */
public class Player {
	public final static int UNPLAYED = -1000;
	
	private String mName;
	
	private int mSchool1 = UNPLAYED;
	private int mSchool2 = UNPLAYED;
	private int mSchool3 = UNPLAYED;
	private int mSchool4 = UNPLAYED;
	private int mSchool5 = UNPLAYED;
	private int mSchool6 = UNPLAYED;

	private int mPair = UNPLAYED;
	private int mDoublePair = UNPLAYED;

	private int mSet = UNPLAYED;
	private int mCare = UNPLAYED;
	private int mOdds = UNPLAYED;
	private int mEvens = UNPLAYED;

	private int mLittleStreet = UNPLAYED;
	private int mBigStreet = UNPLAYED;
	private int mShortStreet = UNPLAYED;

	private int mMizer = UNPLAYED;
	private int mSum = UNPLAYED;
	private int mFullHouse = UNPLAYED;

	private int mPoker = UNPLAYED;
	
	public String getName() {
		return mName;
	}
	public void setName(String name) {
		mName = name;
	}
	public int getSchool1() {
		return mSchool1;
	}
	public void setmSchool1(int school1) {
		mSchool1 = school1;
	}
	public int getSchool2() {
		return mSchool2;
	}
	public void setSchool2(int school2) {
		mSchool2 = school2;
	}
	public int getSchool3() {
		return mSchool3;
	}
	public void setSchool3(int school3) {
		mSchool3 = school3;
	}
	public int getSchool4() {
		return mSchool4;
	}
	public void setSchool4(int school4) {
		mSchool4 = school4;
	}
	public int getSchool5() {
		return mSchool5;
	}
	public void setSchool5(int school5) {
		mSchool5 = school5;
	}
	public int getSchool6() {
		return mSchool6;
	}
	public void setSchool6(int school6) {
		mSchool6 = school6;
	}
	public int getPair() {
		return mPair;
	}
	public void setmPair(int pair) {
		mPair = pair;
	}
	public int getDoublePair() {
		return mDoublePair;
	}
	public void setDoublePair(int doublePair) {
		mDoublePair = doublePair;
	}
	public int getSet() {
		return mSet;
	}
	public void setSet(int set) {
		mSet = set;
	}
	public int getCare() {
		return mCare;
	}
	public void setCare(int care) {
		mCare = care;
	}
	public int getOdds() {
		return mOdds;
	}
	public void setOdds(int odds) {
		mOdds = odds;
	}
	public int getEvens() {
		return mEvens;
	}
	public void setEvens(int evens) {
		mEvens = evens;
	}
	public int getLittleStreet() {
		return mLittleStreet;
	}
	public void setLittleStreet(int littleStreet) {
		mLittleStreet = littleStreet;
	}
	public int getBigStreet() {
		return mBigStreet;
	}
	public void setBigStreet(int bigStreet) {
		mBigStreet = bigStreet;
	}
	public int getShortStreet() {
		return mShortStreet;
	}
	public void setShortStreet(int shortStreet) {
		mShortStreet = shortStreet;
	}
	public int getMizer() {
		return mMizer;
	}
	public void setMizer(int mizer) {
		mMizer = mizer;
	}
	public int getSum() {
		return mSum;
	}
	public void setSum(int sum) {
		mSum = sum;
	}
	public int getFullHouse() {
		return mFullHouse;
	}
	public void setFullHouse(int fullHouse) {
		mFullHouse = fullHouse;
	}
	public int getPoker() {
		return mPoker;
	}
	public void setmPoker(int poker) {
		mPoker = poker;
	}
}
