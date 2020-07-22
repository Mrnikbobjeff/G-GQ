<?xml version="1.0" encoding="UTF-8"?>
<workflow:Workflow xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mltgg.mote2.workflowComponent="http://www.mdelab.de/mltgg/mote2/workflowComponent/1.0" xmlns:workflow="http://mdelab/workflow/1.0" xmlns:workflow.components="http://mdelab/workflow/components/1.0" xmi:id="_V0Z4UMW1EeqPEvb35pZWuQ" name="workflow">
  <components xsi:type="workflow.components:ModelReader" xmi:id="_YF3koMW1EeqPEvb35pZWuQ" name="modelReader" description="GGq2henshin" modelSlot="GGQ" modelURI="platform:resource/GGQ.examples\models\sample.gql"/>
  <components xsi:type="mltgg.mote2.workflowComponent:Mote2Transformer" xmi:id="_au74oMW1EeqPEvb35pZWuQ" name="mote2Transformer" tggID="x2y" debugOutput="true">
    <leftModelSlots>GGQ</leftModelSlots>
    <rightModelSlots>Henshin</rightModelSlots>
  </components>
  <components xsi:type="workflow.components:ModelWriter" xmi:id="_Zn_esMW1EeqPEvb35pZWuQ" name="modelWriter" modelSlot="Henshin" modelURI="platform:/resource/GGQ.examples/out.henshin"/>
</workflow:Workflow>
