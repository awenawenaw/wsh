package nccloud.web.wsh.xsckd.xsckdmaster.action;
import java.util.HashMap;
import java.util.Map;


import nc.bs.dao.BaseDAO;
import nc.vo.wsh.xsckd.XsckdMasterVO;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.wsh.xsckd.AggXsckdMasterVO;
import nc.itf.wsh.xsckd.xsckdmaster.IXsckdMasterVOService;


/**
 * ����Action
 */
public class AddXsckdMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		Map<String,Object> userJson = param.getUserJson();

		AggXsckdMasterVO[] vos = this.getVOs(param, AggXsckdMasterVO.class);
        //���ʵ��VO
		IXsckdMasterVOService service = ServiceLocator.find(IXsckdMasterVOService.class);
		AggXsckdMasterVO vo = service.preAddAggXsckdMasterVO(vos[0],userJson);


		return buildResult(param,true,null,vo);
		
	}

}