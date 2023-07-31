
package nc.impl.wsh.lsgyjcd.lsgyjcdmaster;

import nc.ui.pub.print.IDataSource;
import nccloud.pubitf.platform.print.AbstractPrintService;
import nccloud.pubitf.platform.print.IPrintInfo;
import nccloud.pubitf.platform.print.vo.PrintInfo;

public class AggLsgyjcdMasterVOPrintServiceImpl extends AbstractPrintService {
	
	@Override
    public IDataSource[] getDataSources(IPrintInfo info) {
        PrintInfo printinfo = (PrintInfo) info;
        String[] ids = printinfo.getIds();
        AggLsgyjcdMasterVOPrintDataSource ds = new AggLsgyjcdMasterVOPrintDataSource(ids);
       	return new IDataSource[] { ds };
       
    }
}