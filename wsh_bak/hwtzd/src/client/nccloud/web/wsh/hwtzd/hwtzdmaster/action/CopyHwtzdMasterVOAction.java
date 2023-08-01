package nccloud.web.wsh.hwtzd.hwtzdmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.hwtzd.hwtzd.AggHwtzdMasterVO;
import nc.itf.wsh.hwtzd.hwtzdmaster.IHwtzdMasterVOService;

/**
 * �༭Action
 */
public class CopyHwtzdMasterVOAction extends BaseAction{
	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		String pk = param.getPk();
		
		IHwtzdMasterVOService service = ServiceLocator.find(IHwtzdMasterVOService.class);
		
		AggHwtzdMasterVO vo = service.copyAggHwtzdMasterVO(pk);
		
		if(vo == null){
			return null;
		}
		return buildResult(param,true,null,vo);
	}
	
}