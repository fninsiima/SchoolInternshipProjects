<table border="1">
        <tr>
                <th>DATE</th>
                <th>TIME</th>
                <th>COMMAND STATUS</th>
                <th>SENDER</th>
                <th>RECEIVER</th>
        </tr>
<?php
ini_set('max_execution_time', 300); //300 seconds = 5 minutes
$fp=new SplFileObject('bearerbox_server.log');
$partA=0;
$partB=0;
$partC=0;
while(!$fp->eof()){
	
	if(!preg_match("/submit_sm_resp/",$fp->current()) && !preg_match("/deliver_sm_resp/",$fp->current()) && (preg_match("/submit_sm/",$fp->current()) || preg_match("/deliver_sm/",$fp->current()))){
        $fp->next();
        $commandIDStr=explode(' ', $fp->current());
        $size=count($commandIDStr);
        if($partA==$commandIDStr[$size-3] && $partB==$commandIDStr[$size-2] && $partC==$commandIDStr[$size-1]){
                // do nothing
        }else{
                $partA=$commandIDStr[$size-3];
                $partB=$commandIDStr[$size-2];
                $partC=$commandIDStr[$size-1];
                $fp->next();
                $commandStatusStr=explode(' ',$fp->current());
                $date=$commandStatusStr[0];
                $time=$commandStatusStr[1];
        $length=count($commandStatusStr);
        $part1=$commandStatusStr[$length - 3];
        $part2=$commandStatusStr[$length - 2];
        $part3=$commandStatusStr[$length - 1];
        $linenum=$fp->key();
        $fp->seek($linenum + 5);
        $sourceAddrStr=explode(' ',$fp->current());
        $length=count($sourceAddrStr);
        $sceAddr=$sourceAddrStr[$length - 1];
        $linenum=$fp->key();
        $fp->seek($linenum + 3);
        $destinationAddrStr=explode(' ',$fp->current());
        $length=count($destinationAddrStr);
        $destAddr=$destinationAddrStr[$length - 1];
        ?>
        <tr>
                <td><?php echo $date;?></td>
                <td><?php echo $time;?></td>
                <td><?php echo $part1." ".$part2." ".$part3;?></td>
                <td><?php echo $sceAddr;?></td>
                <td><?php echo $destAddr;?></td>
        </tr>
        
	<?php
                }
        }
	$fp->next();
}
?>
</table>
