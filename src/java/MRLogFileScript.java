//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.LinkedHashSet;
//import java.util.Properties;
//import java.util.Set;
//
//import org.apache.log4j.Logger;
//
//public class MRLogFileScript {
//
//	private String inputFileName = "MR-log.txt";
//	private String propertiesFile = "MRLogFileScript.properties";
//	private Properties props = new Properties();
//
//	private final static String OPEN_REQ = "OPENREQ";
//	private final static String NEW_TASK = "NEWTASK";
//	private final static String MESSAGE = "Message";
//	private final static String DTWT = "DTWT";
//	private final static String ACTIVITYID = "user.cim.activity.id";
//	private final static String MRDCOMAINID = "MRDomainID";
//
//	private static Logger logger = Logger.getLogger(MRLogFileScript.class);
//
//	/**
//	 * This is the function for the execution of the whole script.
//	 *
//	 */
//	private void executeScript() {
//		LinkedHashSet<MRLogTO> newTaskSetForPreviousConn = new LinkedHashSet<MRLogTO>();
//		LinkedHashSet<MRLogTO> newTaskSetForCurrentConn = new LinkedHashSet<MRLogTO>();
//		LinkedHashSet<MRLogTO> tmpTaskSet = null;
//		File f = new File(inputFileName);
//		FileReader fr = null;
//		BufferedReader bfr = null;
//		String line;
//		String previousLine = null;
//		String lastTime = null;
//		try {
//			fr = new FileReader(f);
//			bfr = new BufferedReader(fr);
//			while (true) {
//				line = bfr.readLine();
//				if (line != null && line.startsWith(MESSAGE) || line == null) {
//
//					if (line != null && checkOPEN_REQ(line) || line == null) {
//						checkOrderOfNEW_TASKS(newTaskSetForPreviousConn,
//								newTaskSetForCurrentConn, lastTime);
//						if (line == null) {
//							break;
//						}
//						tmpTaskSet = newTaskSetForCurrentConn;
//						newTaskSetForCurrentConn = newTaskSetForPreviousConn;
//						newTaskSetForPreviousConn = tmpTaskSet;
//						newTaskSetForCurrentConn.clear();
//						lastTime = getTime(previousLine);
//					}
//
//					storeDataInNewTaskSet(line, bfr, newTaskSetForCurrentConn);
//
//				}
//				previousLine = line;
//			}
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			logger.error(e.getMessage(), e);
//		} finally {
//			try {
//				bfr.close();
//				fr.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				logger.error(e.getMessage(), e);
//			}
//		}
//	}
//
//	/**
//	 * It checks whether the req line has OPEN_REQ event in it or not.
//	 *
//	 * @param req
//	 * @return
//	 */
//	private boolean checkOPEN_REQ(String req) {
//
//		if (req.contains(getFromProperties(OPEN_REQ))) {
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * It checks whether the req line has the NEW_TASK event in it.
//	 *
//	 * @param req
//	 * @return
//	 */
//	private boolean checkNEW_TASK(String req) {
//		if (req.contains(getFromProperties(NEW_TASK))) {
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * It checks whether the req line has the DTWT in it.
//	 *
//	 * @param req
//	 * @return
//	 */
//	private boolean checkDTWT(String req) {
//		if (req.contains(getFromProperties(DTWT))) {
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * It keeps on reading the buffered reader until it gets the next activity
//	 * id. Finally it returns the activity id.
//	 *
//	 * @param r
//	 * @return
//	 */
//	private String getNextActivityIDFromReader(BufferedReader r) {
//		String line = null;
//		try {
//			while ((line = r.readLine()) != null) {
//				if (line.contains(ACTIVITYID)) {
//					line = r.readLine();
//					if (line != null) {
//						line = line.substring(line.indexOf(":") + 1, line
//								.length());
//						line = line.trim();
//						break;
//					}
//				} else {
//					continue;
//				}
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			logger.error(e.getMessage(), e);
//		}
//		return line;
//	}
//
//	/**
//	 * This functions returns the first found MR Domain Id from the buffered
//	 * reader.
//	 *
//	 * @param r
//	 * @return
//	 */
//	private String getNextMRDomainID(BufferedReader r) {
//		String line = null;
//		try {
//			while ((line = r.readLine()) != null) {
//				if (line.contains(MRDCOMAINID)) {
//					line = line.substring(line.indexOf("(") + 1, line
//							.indexOf(")"));
//					line = line.trim();
//					break;
//
//				} else {
//					continue;
//				}
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			logger.error(e.getMessage(), e);
//		}
//		return line;
//	}
//
//	/**
//	 * First it checks whether the currentLine contains the NEW_TASK event or
//	 * DTWT event. For NEW_TASK event, it adds the activity id of the
//	 * corresponding event in the newTaskSet. For DTWT event, it checks if the
//	 * newTaskSet contains the activity id or not. If it does then it removes
//	 * the activity id from the newTaskSet.
//	 *
//	 * @param currentLine
//	 * @param bfr
//	 * @param newTaskSet
//	 */
//	private void storeDataInNewTaskSet(String currentLine, BufferedReader bfr,
//			Set<MRLogTO> newTaskSet) {
//		MRLogTO mrLogTO = new MRLogTO();
//		if (checkNEW_TASK(currentLine)) {
//			if ((currentLine = getNextMRDomainID(bfr)) != null) {
//				mrLogTO.setMrDomainId(currentLine);
//			}
//			if ((currentLine = getNextActivityIDFromReader(bfr)) != null) {
//				mrLogTO.setActivityID(currentLine);
//				newTaskSet.add(mrLogTO);
//			}
//		} else if (checkDTWT(currentLine)) {
//
//			if ((currentLine = getNextActivityIDFromReader(bfr)) != null) {
//				mrLogTO.setActivityID(currentLine);
//				if (newTaskSet.contains(mrLogTO)) {
//					newTaskSet.remove(mrLogTO);
//				}
//			}
//		}
//	}
//
//	/**
//	 * This function prints the contents of newTaskSet into a log file.
//	 *
//	 * @param newTaskSet
//	 */
//	private void printTasksInLogFile(Set<MRLogTO> newTaskSet) {
//
//		for (MRLogTO mrlogTO : newTaskSet) {
//			logger.info("NEW_TASK activity id is " + mrlogTO.getActivityID()
//					+ " and MR Domain Id is " + mrlogTO.getMrDomainId() + ".");
//		}
//
//	}
//
//	/**
//	 *
//	 * @param req
//	 * @return
//	 */
//	private String getTime(String req) {
//		if (req != null) {
//			return req.substring(0, 8);
//		}
//		return null;
//	}
//
//	/**
//	 * It checks that the order of the NEW_TASK is same in this connection as
//	 * that of previous connection.
//	 *
//	 * @param newTaskSetForPreviousConn
//	 * @param newTaskSetForCurrentConn
//	 * @param lastTime
//	 */
//	private void checkOrderOfNEW_TASKS(
//			LinkedHashSet<MRLogTO> newTaskSetForPreviousConn,
//			LinkedHashSet<MRLogTO> newTaskSetForCurrentConn, String lastTime) {
//		if (lastTime == null) {
//			printTasksInLogFile(newTaskSetForCurrentConn);
//		} else {
//			Iterator<MRLogTO> itrFirst = newTaskSetForPreviousConn.iterator();
//			Iterator<MRLogTO> itrSecond = newTaskSetForCurrentConn.iterator();
//			MRLogTO firstItrElement;
//			MRLogTO secondItrElement;
//
//			logger.info("");
//			logger.info(":::::::::::::::: New connection starts at " + lastTime
//					+ " :::::::::::::::");
//			while (itrFirst.hasNext() && itrSecond.hasNext()) {
//				firstItrElement = itrFirst.next();
//				if (!newTaskSetForCurrentConn.contains(firstItrElement)) {
//					continue;
//				}
//				secondItrElement = itrSecond.next();
//				if (firstItrElement.equals(secondItrElement)) {
//					continue;
//				} else {
//					logger.info("Order of NEW_TASK activities in this connection is not same as the activities in previous connection");
//					logger.info("The order breaks at the new task activity id "
//							+ secondItrElement.getActivityID());
//					return;
//				}
//			}
//			printTasksInLogFile(newTaskSetForCurrentConn);
//		}
//	}
//
//	/**
//	 * It returns the value of the req from the properties file.
//	 *
//	 * @param req
//	 * @return
//	 */
//	private String getFromProperties(String req) {
//		try {
//			if (props.isEmpty()) {
//				props.load(new FileInputStream(propertiesFile));
//			}
//			return props.getProperty(req);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			logger.error("Property file is not found: "+propertiesFile , e);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			logger.error("There is some io error in reading the property file: "+propertiesFile, e);
//		}
//		return null;
//	}
//
//	public static void main(String[] args) {
//
//		// :::::: This is the starting point of MRLogFileScripts :::::::
//		MRLogFileScript mrlogFileScript = new MRLogFileScript();
//		mrlogFileScript.executeScript();
//
//	}
//
//}
//
//class MRLogTO {
//	private String activityID;
//	private String mrDomainId;
//
//	public String getActivityID() {
//		return activityID;
//	}
//
//	public void setActivityID(String activityID) {
//		this.activityID = activityID;
//	}
//
//	public String getMrDomainId() {
//		return mrDomainId;
//	}
//
//	public void setMrDomainId(String mrDomainId) {
//		this.mrDomainId = mrDomainId;
//	}
//
//	@Override
//	public int hashCode() {
//		if (activityID != null) {
//			return activityID.hashCode();
//		}
//		return super.hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof MRLogTO && ((MRLogTO) obj).getActivityID() != null) {
//			return ((MRLogTO) obj).getActivityID().equals(activityID);
//		}
//		return super.equals(obj);
//	}
//}
