package by.lex.dices;

public class ResultManager {
	private static ResultManager mInstance;

	private int mOnes;
	private int mTwoes;
	private int mThrees;
	private int mFours;
	private int mFives;
	private int mSixes;

	private int mSchool1;
	private int mSchool2;
	private int mSchool3;
	private int mSchool4;
	private int mSchool5;
	private int mSchool6;

	private int mPair;
	private int mDoublePair;

	private int mSet;
	private int mCare;
	private int mOdds;
	private int mEvens;

	private int mLittleStreet;
	private int mBigStreet;
	private int mShortStreet;

	private int mMizer;
	private int mSum;
	private int mFullHouse;
	private int mPoker;

	public static ResultManager getInstance() {
		if (mInstance == null) {
			mInstance = new ResultManager();
		}

		return mInstance;
	}

	private ResultManager() {
		mSchool1 = 0;
		mSchool2 = 0;
		mSchool3 = 0;
		mSchool4 = 0;
		mSchool5 = 0;
		mSchool6 = 0;

		mPair = 0;
		mDoublePair = 0;
		mSet = 0;
		mCare = 0;
		mOdds = 0;
		mEvens = 0;

		mLittleStreet = 0;
		mBigStreet = 0;
		mShortStreet = 0;
		mMizer = 0;
		mSum = 0;
		mFullHouse = 0;
		mPoker = 0;
	}

	public int getSchool1() {
		return mSchool1;
	}

	public int getSchool2() {
		return mSchool2;
	}

	public int getSchool3() {
		return mSchool3;
	}

	public int getSchool4() {
		return mSchool4;
	}

	public int getSchool5() {
		return mSchool5;
	}

	public int getSchool6() {
		return mSchool6;
	}

	public int getSchoolTotal() {
		return mSchool1 + mSchool2 + mSchool3 + mSchool4 + mSchool5 + mSchool6;
	}

	public int getPair() {
		return mPair;
	}

	public int getDoublePair() {
		return mDoublePair;
	}

	public int getSet() {
		return mSet;
	}

	public int getCare() {
		return mCare;
	}

	public int getOdds() {
		return mOdds;
	}

	public int getEvens() {
		return mEvens;
	}

	public int getLittleStreet() {
		return mLittleStreet;
	}

	public int getBigStreet() {
		return mBigStreet;
	}

	public int getShortStreet() {
		return mShortStreet;
	}

	public int getMizer() {
		return mMizer;
	}

	public int getSum() {
		return mSum;
	}

	public int getFullHouse() {
		return mFullHouse;
	}

	public int getPoker() {
		return mPoker;
	}

	private void reset() {
		mOnes = 0;
		mTwoes = 0;
		mThrees = 0;
		mFours = 0;
		mFives = 0;
		mSixes = 0;
	}

	private int[] gatherNumsFromDices(int[] values) {
		reset();

		for (int v : values) {
			switch (v) {
			case 1:
				mOnes++;
				break;
			case 2:
				mTwoes++;
				break;
			case 3:
				mThrees++;
				break;
			case 4:
				mFours++;
				break;
			case 5:
				mFives++;
				break;
			case 6:
				mSixes++;
				break;

			default:
				break;
			}
		}

		int[] nums = { mOnes, mTwoes, mThrees, mFours, mFives, mSixes };
		return nums;
	}

	private int calcSum(int[] nums) {
		int value = 0;

		for (int i = 6; i > 0; i--) {
			int index = i - 1;
			int count = nums[index];

			value += i * count;
		}

		return value;
	}

	private void calcPair(int[] nums) {
		mPair = 0;

		for (int i = 6; i > 0; i--) {
			int index = i - 1;
			int count = nums[index];

			if (count >= 2) {
				mPair = i * 2;
				return;
			}
		}
	}

	private void calcDoublePair(int[] nums) {
		int value1 = 0;
		int value2 = 0;

		for (int i = 6; i > 0; i--) {
			int index = i - 1;
			int count = nums[index];

			if (count >= 4) {
				mDoublePair = i * 4;
				return;
			} else if (count >= 2) {
				if (value1 > 0) {
					value2 = i * 2;
					break;
				} else {
					value1 = i * 2;
				}
			}
		}

		if (value1 > 0 && value2 > 0) {
			mDoublePair = value1 + value2;
		} else {
			mDoublePair = 0;
		}
	}

	private void calcSet(int[] nums) {
		mSet = 0;

		for (int i = 6; i > 0; i--) {
			if (nums[i - 1] >= 3) {
				mSet = i * 3;
				return;
			}
		}
	}

	private void calcCare(int[] nums) {
		mCare = 0;

		for (int i = 6; i > 0; i--) {
			if (nums[i - 1] >= 4) {
				mCare = i * 4;
				return;
			}
		}
	}

	private void calcOdds(int[] nums) {
		// no even nums
		if (nums[1] == 0 && nums[3] == 0 && nums[5] == 0) {
			mOdds = calcSum(nums);
		} else {
			mOdds = 0;
		}
	}

	private void calcEvens(int[] nums) {
		// no odd nums
		if (nums[0] == 0 && nums[2] == 0 && nums[4] == 0) {
			mEvens = calcSum(nums);
		} else {
			mEvens = 0;
		}
	}

	private void calcStreet(int[] nums) {
		mLittleStreet = 0;
		mBigStreet = 0;
		boolean isStreet = true;

		for (int n : nums) {
			isStreet &= (n <= 1);

			if (!isStreet) {
				return;
			}
		}

		if (nums[5] > 0) {
			mBigStreet = 20;
		} else {
			mLittleStreet = 15;
		}
	}

	private void calcShortStreet(int[] nums) {
		mShortStreet = 0;
		boolean canBeStreet = true;
        //
		
		for (int n : nums) {
			canBeStreet &= (n < 3);

			if (!canBeStreet) {
				return;
			}
		}

		boolean isLeftPart = (nums[0] > 0 || nums[1] > 0);//
		boolean isCenterPart = (nums[2] > 0 && nums[3] > 0);
		boolean isRightPart = (nums[4] > 0 || nums[5] > 0);//
		boolean isTwoOrFive = (nums[1] > 0 || nums[4] > 0);

		if (isLeftPart && isCenterPart && isRightPart && isTwoOrFive) {
			mShortStreet = 20;
		}
	}

	private void calcMizer(int[] nums) {
		mMizer = calcSum(nums);
		mMizer = 30 - mMizer;
	}

	private void calcFullSum(int[] nums) {
		mSum = calcSum(nums);
	}

	private void calcFullHouse(int[] nums) {
		mFullHouse = 0;
		boolean isPair = false;
		boolean isSet = false;

		for (int n : nums) {
			if (n == 2 && !isPair) {
				isPair = true;
				continue;
			}

			if (n == 3 && !isSet) {
				isSet = true;
				continue;
			}
		}

		if (isPair && isSet) {
			mFullHouse = calcSum(nums);
		}
	}

	private void calcPoker(int[] nums) {
		mPoker = 0;

		for (int i = 6; i > 0; i--) {
			if (nums[i - 1] == 5) {
				mPoker = 100 + i * 10;
				return;
			}
		}
	}

	public void calculateResult(int[] values) {
		// int[] values - dice values
		// int[] nums - counts of values (ones, twoes, ... sixes)
		int[] nums = gatherNumsFromDices(values);

		mSchool1 = (mOnes - 3) * 10;
		mSchool2 = (mTwoes - 3) * 20;
		mSchool3 = (mThrees - 3) * 30;
		mSchool4 = (mFours - 3) * 40;
		mSchool5 = (mFives - 3) * 50;
		mSchool6 = (mSixes - 3) * 60;

		calcPair(nums);
		calcDoublePair(nums);
		calcSet(nums);
		calcCare(nums);
		calcOdds(nums);
		calcEvens(nums);

		calcStreet(nums);
		calcShortStreet(nums);
		calcMizer(nums);
		calcFullSum(nums);
		calcFullHouse(nums);
		calcPoker(nums);
	}

}
