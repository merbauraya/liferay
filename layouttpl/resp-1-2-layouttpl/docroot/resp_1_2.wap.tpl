<div class="container-fluid">
	<div class="row-fluid">
		<div class="span2">
			<div class="row">
				<div class="portlet-column portlet-column-first" id="column-2">
					 $processor.processColumn("column-2", "portlet-column-content portlet-column-content-first")
				</div>
			</div>
			<div class="row">
				<div class="portlet-column" id="column-3">
					$processor.processColumn("column-3", "portlet-column-content")
				</div>
			</div>
			<div class="row">
				<div class="portlet-column" id="column-4">
					$processor.processColumn("column-4", "portlet-column-content")
				</div>
			</div>
		</div>
		<div class="span10">
			<div class="portlet-column portlet-column-first" id="column-1">
				$processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")
			</div>
		</div>
	</div>
</div>