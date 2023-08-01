package nccloud.web.wsh.xsckd.xsckdmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.wsh.xsckd.AggXsckdMasterVO;
import nc.itf.wsh.xsckd.xsckdmaster.IXsckdMasterVOService;

/**
 * �༭Action
 */
public class CopyXsckdMasterVOAction extends BaseAction{
	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		String pk = param.getPk();
		
		IXsckdMasterVOService service = ServiceLocator.find(IXsckdMasterVOService.class);
		
		AggXsckdMasterVO vo = service.copyAggXsckdMasterVO(pk);
		
		if(vo == null){
			return null;
		}
		return buildResult(param,true,null,vo);
	}
	
}