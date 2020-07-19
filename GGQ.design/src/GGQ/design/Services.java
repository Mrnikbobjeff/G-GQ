package GGQ.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * The services class used by VSM.
 */
public class Services {

	private List<EClass> allClasses;
	private Set<String> filteredURIs;
	
	public Services() {
		initializeFilteredURIs();
		initializeClasses();
	}
	
	/**
    * See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24 for documentation on how to write service methods.
    */
    public EObject myService(EObject self, String arg) {
       // TODO Auto-generated code
      return self;
    }
    
	public List<EClass> getAllEClasses(EObject self) {
		return allClasses;
	}

    private void initializeFilteredURIs() {
		filteredURIs = new HashSet<String>();
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/table/validation/model");
		filteredURIs.add("http://www.eclipse.org/sirius/diagram/sequence/template/2.0.0");
		filteredURIs.add("http://eclipse.org/emf/emfstore/common/model");
		filteredURIs.add("http://mdelab/workflow/components/benchmark/1.0");
		filteredURIs.add("http://www.eclipse.org/gmf/runtime/1.0.3/notation");
		filteredURIs.add("http://www.eclipse.org/sirius/description/validation/1.1.0");
		filteredURIs.add("http://www.eclipse.org/emf/2004/Ecore2Ecore");
		filteredURIs.add("http://www.eclipse.org/oomph/resources/1.0");
		filteredURIs.add("http://www.eclipse.org/xtext/common/mwe2/Mwe2");
		filteredURIs.add("http://www.eclipse.org/ui/2010/UIModel/application");
		filteredURIs.add("http://www.eclipse.org/elk/ElkGraph");
		filteredURIs.add("http://www.eclipse.org/ocl/1.1.0/oclstdlib.ecore");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/treemasterview/model");
		filteredURIs.add("http://www.eclipse.org/sirius/description/style/1.1.0");
		filteredURIs.add("http://www.eclipse.org/sirius/1.1.0");
		filteredURIs.add("http://www.eclipse.org/ui/2010/UIModel/application/ui/menu");
		filteredURIs.add("http://www.eclipse.org/emf/validation/2013/Validity");
		filteredURIs.add("http://www.eclipse.org/emf/2013/Henshin/Wrap");
		filteredURIs.add("http://www.eclipse.org/ocl/2015/Lookup");
		filteredURIs.add("http://www.eclipse.org/oomph/setup/p2/1.0");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/vertical/model");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/compoundcontrol/model");
		filteredURIs.add("http://www.eclipse.org/sirius/properties/1.0.0");
		filteredURIs.add("http://www.eclipse.org/oomph/workingsets/1.0");
		filteredURIs.add("http://www.eclipse.org/oomph/p2/1.0");
		filteredURIs.add("http://www.eclipse.org/xtend");
		filteredURIs.add("http://mdelab/workflow/helpers/1.0");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/tab/model");
		filteredURIs.add("http://www.eclipse.org/ocl/2015/MarkupCS");
		filteredURIs.add("http://www.eclipse.org/Oomph/preferences/1.0");
		filteredURIs.add("http://www.eclipse.org/xsd/2002/XSD");
		filteredURIs.add("http://www.eclipse.org/emf/edapt/migration/0.3");
		filteredURIs.add("http://www.eclipse.org/uml2/2.2.0/GenModel");
		filteredURIs.add("http://www.eclipse.org/viatra/query/snapshot");
		filteredURIs.add("http://www.eclipse.org/eef/ext/widgets/reference");
		filteredURIs.add("http://www.eclipse.org/ui/2010/UIModel/application/ui/advanced");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/template/model");
		filteredURIs.add("http://www.eclipse.org/sirius/tree/description/1.0.0");
		filteredURIs.add("http://www.eclipse.org/ocl/2018/Annotations");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/model/1180");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/selector/annotation/model");
		filteredURIs.add("http://www.eclipse.org/emf/2016/Henshin/CriticalPair");
		filteredURIs.add("http://www.eclipse.org/xtext/xbase/Xbase");
		filteredURIs.add("http://www.eclipse.org/uml2/5.0.0/Types");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/categorization/model");
		filteredURIs.add("http://www.eclipse.org/acceleo/mt/2.6.0");
		filteredURIs.add("http://www.eclipse.org/emf/parsley/dsl/EmfParsleyDsl");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/background/model");
		filteredURIs.add("http://www.eclipse.org/emf/2002/GenModel");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/viewproxy/model");
		filteredURIs.add("http://www.eclipse.org/qvt/1.0.0/Operational");
		filteredURIs.add("http://www.eclipse.org/sirius/description/audit/1.1.0");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/selector/domainmodelreference/model");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/selector/bool/model");
		filteredURIs.add("http://www.eclipse.org/ocl/2015/EssentialOCLCS");
		filteredURIs.add("http://www.eclipse.org/acceleo/mt/2.6.0/core");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/reference/model");
		filteredURIs.add("http://www.eclipse.org/sirius/tree/1.0.0");
		filteredURIs.add("http://www.eclipse.org/emf/CDO/Eresource/4.0.0");
		filteredURIs.add("http://www.eclipse.org/2008/Xtext");
		filteredURIs.add("http://www.eclipse.org/emf/compare/diagram/2.0");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/mandatory/model");
		filteredURIs.add("http://www.eclipse.org/uml2/5.0.0/UML");
		filteredURIs.add("http://org/eclipse/emfforms/view/indexsegment/model/1190");
		filteredURIs.add("http://www.eclipse.org/gmf/runtime/1.0.3/notation");
		filteredURIs.add("http://www.eclipse.org/emf/edapt/declaration/0.3");
		filteredURIs.add("http://www.eclipse.org/qvt/1.0/ImperativeOCL");
		filteredURIs.add("http://www.mdelab.de/mlindices/1.0");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/table/model");
		filteredURIs.add("http://www.eclipse.org/sirius/description/1.1.0");
		filteredURIs.add("http://mdelab/workflow/components/mlsdmInterpreter/1.0");
		filteredURIs.add("http://www.mdelab.de/mltgg/ruleDependencyGraph/generator/1.0");
		filteredURIs.add("http://www.eclipse.org/ocl/2015/Values");
		filteredURIs.add("http://www.eclipse.org/sirius/diagram/description/filter/1.1.0");
		filteredURIs.add("http://www.eclipse.org/emf/2010/Henshin/StateSpace");
		filteredURIs.add("http://www.eclipse.org/sirius/diagram/description/concern/1.1.0");
		filteredURIs.add("http://www.eclipse.org/sirius/diagram/sequence/description/tool/2.0.0");
		filteredURIs.add("http:///www.eclipse.org/m2m/qvt/operational/trace.ecore");
		filteredURIs.add("http://www.eclipse.org/xtend/RichString");
		filteredURIs.add("http://www.mdelab.de/mltgg/mote2/generator/1.0");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/custom/model");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/label/model");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/fontProperties/model");
		filteredURIs.add("http://www.eclipse.org/sirius/diagram/1.1.0");
		filteredURIs.add("http://www.eclipse.org/ocl/2015/CompleteOCLCS");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/alignment/model");
		filteredURIs.add("http://www.eclipse.org/ocl/2015/Library");
		filteredURIs.add("http://www.eclipse.org/oomph/setup/sync/1.0");
		filteredURIs.add("http://www.eclipse.org/qvt/1.0.0/Operational/Expressions");
		filteredURIs.add("http://www.eclipse.org/elk/GraphvizDot");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/labelwidth/model");
		filteredURIs.add("http://www.eclipse.org/ocl/2015/OCLstdlibCS");
		filteredURIs.add("http://www.eclipse.org/emf/2003/Change");
		filteredURIs.add("http://www.eclipse.org/sirius/table/1.1.0");
		filteredURIs.add("http://www.eclipse.org/emf/CDO/security/4.1.0");
		filteredURIs.add("http://www.eclipse.org/ui/2010/UIModel/fragment");
		filteredURIs.add("http://www.eclipse.org/emf/CDO/expressions/4.3.0");
		filteredURIs.add("http://www.eclipse.org/sirius/diagram/sequence/2.0.0");
		filteredURIs.add("http://www.eclipse.org/acceleo/mt/2.6.0/expressions");
		filteredURIs.add("http://www.eclipse.org/oomph/predicates/1.0");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/horizontal/model");
		filteredURIs.add("http://www.eclipse.org/sirius/diagram/description/tool/1.1.0");
		filteredURIs.add("http://www.eclipse.org/ocl/1.1.0/OCL/CST");
		filteredURIs.add("http://www.eclipse.org/ui/2010/UIModel/application/ui");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/indexdmr/model");
		filteredURIs.add("http://www.eclipse.org/acceleo/traceability/1.0");
		filteredURIs.add("http://www.eclipse.org/sirius/properties/1.0.0/ext/widgets/reference");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/mappingdmr/model");
		filteredURIs.add("http://mdelab/workflow/components/qvtoTransformer/1.0");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/stack/model");
		filteredURIs.add("http://www.eclipse.org/viatra/addon/viewers/notation/1.0");
		filteredURIs.add("http://www.eclipse.org/ocl/1.0.0/CG");
		filteredURIs.add("http://www.eclipse.org/emf/edapt/history/0.3");
		filteredURIs.add("http://org/eclipse/emfforms/view/mappingsegment/model/1190");
		filteredURIs.add("http://www.eclipse.org/emf/2003/XMLType");
		filteredURIs.add("http://www.eclipse.org/ui/2010/UIModel/application/commands");
		filteredURIs.add("http://www.eclipse.org/sirius/diagram/description/1.1.0");
		filteredURIs.add("http://www.eclipse.org/emf/2009/Validation");
		filteredURIs.add("http://www.mdelab.de/mltgg/mote2/helpers/1.0");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/group/model");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/selector/viewmodelelement/model");
		filteredURIs.add("http://www.eclipse.org/oomph/base/1.0");
		filteredURIs.add("http://www.eclipse.org/gmf/runtime/1.0.3/notation");
		filteredURIs.add("http://www.eclipse.org/xtext/codetemplate/Codetemplates");
		filteredURIs.add("http://www.mdelab.de/mltgg/mote2/workflowComponent/1.0");
		filteredURIs.add("http://www.eclipse.org/xtext/trace/debug/1.0");
		filteredURIs.add("http://www.eclipse.org/emf/henshin/text/Henshin_text");
		filteredURIs.add("http://www.eclipse.org/eef");
		filteredURIs.add("http://www.eclipse.org/emf/CDO/Etypes/4.0.0");
		filteredURIs.add("http://www.eclipse.org/sirius/diagram/sequence/ordering/2.0.0");
		filteredURIs.add("http://www.eclipse.org/ocl/1.1.0/OCL/Types");
		filteredURIs.add("http://www.eclipse.org/ui/2010/UIModel/application/descriptor/basic");
		filteredURIs.add("http://www.eclipse.org/emf/CDO/admin/RepositoryCatalog/4.3.0");
		filteredURIs.add("http://www.eclipse.org/ocl/2015/OCLforUML/1");
		filteredURIs.add("http://www.eclipse.org/viatra/query/patternlanguage/emf/PatternLanguage");
		filteredURIs.add("http://www.eclipse.org/ocl/1.1.0/OCL/Utilities");
		filteredURIs.add("http://www.eclipse.org/ocl/1.1.0/Ecore");
		filteredURIs.add("http://www.eclipse.org/ui/2010/UIModel/application/ui/basic");
		filteredURIs.add("http://www.eclipse.org/emf/2002/XSD2Ecore");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/wrap/model");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/validation/model");
		filteredURIs.add("http://www.eclipse.org/ocl/1.1.0/OCL/Expressions");
		filteredURIs.add("http://www.eclipse.org/emf/2005/Ecore2XML");
		filteredURIs.add("http://www.eclipse.org/viatra/query/tooling/generator/model/QueryGenModel");
		filteredURIs.add("http://www.eclipse.org/sirius/table/description/1.1.0");
		filteredURIs.add("http://www.mdelab.de/sdm/icl/ICL");
		filteredURIs.add("http://www.eclipse.org/emf/2002/Mapping");
		filteredURIs.add("http://www.eclipse.org/ocl/2015/BaseCS");
		filteredURIs.add("http://www.eclipse.org/oomph/setup/1.0");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/table/model/150");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/selector/hierarchy/model");
		filteredURIs.add("http://www.mdelab.de/mltgg/mote2/1.0");
		filteredURIs.add("http://www.eclipse.org/emf/2002/Tree");
		filteredURIs.add("http://org/eclipse/emfforms/view/multisegment/model/1190");
		filteredURIs.add("http://www.eclipse.org/sirius/diagram/description/style/1.1.0");
		filteredURIs.add("http://www.mdelab.de/mltgg/mote2/generator/traces/1.0");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/textcontrol/enablement/model");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/keybinding/model");
		filteredURIs.add("http://www.mdelab.de/mltgg/mote2/sdm/1.0");
		filteredURIs.add("http://www.eclipse.org/viatra/transformation/views/traceability/1.0");
		filteredURIs.add("http://mdelab/workflow/components/1.0");
		filteredURIs.add("http://www.eclipse.org/gmf/runtime/1.0.3/notation");
		filteredURIs.add("http://www.eclipse.org/sirius/description/tool/1.1.0");
		filteredURIs.add("http://www.eclipse.org/ocl/1.1.0/UML");
		filteredURIs.add("http://www.eclipse.org/ocl/2015/OCLinEcoreCS");
		filteredURIs.add("http://www.eclipse.org/sirius/diagram/sequence/description/2.0.0");
		filteredURIs.add("http://www.w3.org/XML/1998/namespace");
		filteredURIs.add("http://org/eclipse/emf/emfforms/view/annotation/model");
		filteredURIs.add("http://www.eclipse.org/xtext/purexbase/PureXbase");
		filteredURIs.add("http://www.eclipse.org/Xtext/Xbase/XAnnotations");
		filteredURIs.add("http://www.eclipse.org/xtext/xbase/Xtype");
		filteredURIs.add("http://mdelab/workflow/1.0");
		filteredURIs.add("http://mdelab/workflow/components/xpandComponent/1.0");
		filteredURIs.add("http://www.eclipse.org/viatra/query/rete/recipes");
		filteredURIs.add("http://www.eclipse.org/QVT2/1.0.0/Operational/cst");
		filteredURIs.add("http://www.eclipse.org/emf/2011/Henshin/Trace");
		filteredURIs.add("http://www.eclipse.org/xtext/common/JavaVMTypes");
		filteredURIs.add("http://www.eclipse.org/ocl/2015/Pivot");
		filteredURIs.add("http://www.eclipse.org/uml2/5.0.0/UML/Profile/Standard");
		filteredURIs.add("http://www.eclipse.org/xtext/builderstate/1.0");
		filteredURIs.add("http://www.eclipse.org/emf/ecp/view/template/style/unsettable/model");
		filteredURIs.add("http://www.eclipse.org/emf/compare");
		filteredURIs.add("http://www.eclipse.org/ocl/1.1.0/OCL");
		filteredURIs.add("http://www.eclipse.org/acceleo/ui/acceleowizardmodel/3.1");
		filteredURIs.add("http://www.eclipse.org/acceleo/mt/2.6.0/statements");
		filteredURIs.add("http://www.mdelab.de/mltgg/ruleDependencyGraph/1.0");
		filteredURIs.add("http://org/eclipse/emf/ecp/view/rule/model");
		filteredURIs.add("http://www.eclipse.org/sirius/dsl/formatdata/1.1.0");
		filteredURIs.add("http://www.eclipse.org/acceleo/query/1.0");
		filteredURIs.add("http://www.mdelab.de/mlsdm/interpreter/coverage/1.0");
		filteredURIs.add("http://www.mdelab.de/mltgg/mote2/operationalTGG/1.0");
		filteredURIs.add("http://www.mdelab.de/sdm/interpreter/core/executionTrace/1.0");
	}

	private void initializeClasses() {
		allClasses = new ArrayList<EClass>();
		
		for(Object o:EPackage.Registry.INSTANCE.values()) {
			if(!(o instanceof EPackage) || filterPackage((EPackage) o)) {
				continue;
			}
			EPackage pkg = (EPackage) o;
//			System.out.println("filteredURIs.add(\"" + pkg.getNsURI() + "\");");
			for(EClassifier classifier:pkg.getEClassifiers()) {
				if(classifier.eClass() == EcorePackage.Literals.ECLASS) {
					allClasses.add((EClass) classifier);
				}
			}
		}
		
		Collections.sort(allClasses, new Comparator<EClass>() {

			@Override
			public int compare(EClass arg0, EClass arg1) {
				return getQualifiedName(arg0).compareTo(getQualifiedName(arg1));
			}

		});
	}

	private String getQualifiedName(EClass arg) {
		return arg.getEPackage().getName() + "." + arg.getName();
	}
	
	private boolean filterPackage(EPackage pkg) {
		return filteredURIs.contains(pkg.getNsURI());
	}
}
