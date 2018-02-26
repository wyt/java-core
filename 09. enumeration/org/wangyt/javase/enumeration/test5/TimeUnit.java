package org.wangyt.javase.enumeration.test5;

/**
 * unit of time enumeration. <BR>
 * 
 * @author WANG YONG TAO
 *
 */
public enum TimeUnit {

	/** minutes */
	MINUTE {

		/**
		 * @see TimeUnit#defaultTime2Millis(int)
		 */
		@Override
		public long defaultTime2Millis(int input) {
			return (long) input * 60 * 1000;
		}
	},

	/** seconds */
	SECOND {

		/**
		 * @see TimeUnit#defaultTime2Millis(int)
		 */
		@Override
		public long defaultTime2Millis(int input) {
			return (long) input * 1000;
		}
	};

	/**
	 * default time to live based on units
	 * 
	 * @param input
	 *            A number of units (seconds or minutes) before cache expires to be
	 *            converted into milliseconds
	 * @return the millis
	 */
	public abstract long defaultTime2Millis(int input);

}