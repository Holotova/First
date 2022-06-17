insert into "curator" (id, birthdate, name, workexperience, universitygroup_id)
values ('13464547-3fdb-4486-a49e-e768c76c7e29', '1986-08-01',
'MyCurator111', 5, 'd3b6d8ec-6d36-4b89-a99b-bb3fa74ffd1d');
insert into "curator" (id, birthdate, name, workexperience, universitygroup_id)
values ('fb1007b9-f829-4f74-9ef0-2f882f799c78', '1988-08-09',
'MyCurator222', 1, '096d7fe7-5ac4-41c0-8ee6-18ef939b60a0');
update universitygroup set curator_id = '13464547-3fdb-4486-a49e-e768c76c7e29'
where id = 'd3b6d8ec-6d36-4b89-a99b-bb3fa74ffd1d';
update universitygroup set curator_id = 'fb1007b9-f829-4f74-9ef0-2f882f799c78'
where id = '096d7fe7-5ac4-41c0-8ee6-18ef939b60a0';