package interviews.microsoft;

/**
 * manufacturing and assembly time is given. Make the most potimized supply chain
 *
 * list <- [MT, AT];
 * sort list on MT;
 *
 * for i in (0 -> len) on list :
 *      out <- list.get(i);
 *      for j in (i+1 -> len) on list :
 *          if list.get(i).MT < list.get(j).AT :
 *              out <- list.get(j);
 *              remove j from list;
 *              break;
 *
 * return out;
 *
 */
public class ManufacturingAndAssemblingUnits {


}
